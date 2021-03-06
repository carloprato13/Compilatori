package codegen;

import exception.SegmentationFaultException;
import exception.VMOutOfMemoryException;
import svm.SVMParser;

import java.util.ArrayList;
import java.util.HashSet;

public class ExecuteVM {

    public static final int MEMORY_START_ADDRESS = 70;
    private static final int MEMSIZE = 100;
    private ArrayList<String> outputBuffer = new ArrayList<>();

    private int[] memory = new int[MEMSIZE];
    private int[] code;

    private int hp = MEMORY_START_ADDRESS;
    private int ip = 0;
    private int sp = MEMORY_START_ADDRESS + MEMSIZE;
    private int fp = MEMORY_START_ADDRESS + MEMSIZE;
    private int ra;
    private int rv;
    private int cp=0;
    private boolean debug;
    private HeapMemory heap = new HeapMemory(MEMSIZE);
    private HashSet<HeapMemoryCell> heapMemoryInUse = new HashSet<>();

    public ExecuteVM(int[] code, boolean debug) {
        this.code = code;
        this.debug = debug;
    }

    private int getMemory(int address) throws SegmentationFaultException {
        int location = address - MEMORY_START_ADDRESS;
        if (location < 0 || location >= MEMSIZE) {
            System.out.println("get LOCATION: "+location+" ADDRESS: "+address);
            throw new SegmentationFaultException();
        }
        return memory[location];
    }

    private void setMemory(int address, int value) throws SegmentationFaultException {
        int location = address - MEMORY_START_ADDRESS;
        if (location < 0 || location >= MEMSIZE) {
            System.out.println("set LOCATION: "+location+" ADDRESS: "+address);
            throw new SegmentationFaultException();             
        }
            
        memory[location] = value;
    }

    private void printMemory() {
        for (int mem : memory)
            System.out.print(mem + " ");
        System.out.println();
        cp++;
        System.out.println("CP: "+cp+" sp: " + sp + "  fp: " + fp + "  ra: " + ra + "  rv: " + rv + "  hp: " + hp);
        System.out.println();
    }

    public ArrayList<String> cpu() {
        try {
            if (debug) {
                System.out.println("start :");
                printMemory();
            }
            while (true) {
                int bytecode = code[ip++]; // fetch
                int v1, v2;
                int address;
                switch (bytecode) {
                    case SVMParser.PUSH:
                        push(code[ip++]);
                        break;
                    case SVMParser.POP:
                        pop();
                        break;
                    case SVMParser.ADD:
                        v1 = pop();
                        v2 = pop();
                        push(v2 + v1);
                        break;
                    case SVMParser.MULT:
                        v1 = pop();
                        v2 = pop();
                        push(v2 * v1);
                        break;
                    case SVMParser.DIV:
                        v1 = pop();
                        v2 = pop();
                        push(v2 / v1);
                        break;
                    case SVMParser.SUB:
                        v1 = pop();
                        v2 = pop();
                        push(v2 - v1);
                        break;
                    case SVMParser.STOREW:
                        address = pop();
                        setMemory(address, pop());
                        break;
                    case SVMParser.LOADW: // Prende l'indirizzo in cima allo stack e pusha il valore puntato sullo stack
                        push(getMemory(pop()));
                        break;
                    case SVMParser.BRANCH:
                        address = code[ip];
                        ip = address;
                        break;
                    case SVMParser.BRANCHEQ:
                        address = code[ip++];
                        v1 = pop();
                        v2 = pop();
                        if (v2 == v1) ip = address;
                        break;
                    case SVMParser.BRANCHLESSEQ:
                        address = code[ip++];
                        v1 = pop();
                        v2 = pop();
                        if (v2 <= v1) ip = address;
                        break;
                    case SVMParser.JS:
                        address = pop();
                        ra = ip;
                        ip = address;
                        break;
                    case SVMParser.STORERA:
                        ra = pop();
                        break;
                    case SVMParser.LOADRA: //
                        push(ra);
                        break;
                    case SVMParser.STORERV:
                        rv = pop();
                        break;
                    case SVMParser.LOADRV:
                        push(rv);
                        break;
                    case SVMParser.LOADFP:
                        push(fp);
                        break;
                    case SVMParser.STOREFP:
                        fp = pop();
                        break;
                    case SVMParser.COPYFP:
                        fp = sp;
                        break;
                    case SVMParser.PRINT:
                        outputBuffer.add((sp < MEMORY_START_ADDRESS + MEMSIZE) ? Integer.toString(getMemory(sp)) : "Empty stack!");
                        break;
                    case SVMParser.NEW:
                        // Il numero di argomenti per il new e' sulla testa dello stack
                        int dispatchTableAddress = pop();
                        int nargs = pop();
                        int[] args = new int[nargs];
                        // Poppo gli argomenti
                        for (int i = nargs - 1; i >= 0; i--) {
                            args[i] = pop();
                        }
                        // Alloco memoria per i nargs argomenti + 1 per l'indirizzo alla dispatch table
                        HeapMemoryCell allocatedMemory;
                        allocatedMemory = heap.allocate(nargs + 1);
                        // Salvo il blocco di memoria ottenuto per controllarlo in garbage collection
                        heapMemoryInUse.add(allocatedMemory);
                        int heapMemoryStart = allocatedMemory.getIndex();
                        // Inserisco l'indirizzo della dispatch table ed avanzo nella memoria ottenuta
                        setMemory(allocatedMemory.getIndex(), dispatchTableAddress);
                        allocatedMemory = allocatedMemory.next;
                        // Inserisco un argument in ogni indirizzo di memoria
                        for (int i = 0; i < nargs; i++) {
                            setMemory(allocatedMemory.getIndex(), args[i]);
                            allocatedMemory = allocatedMemory.next;
                        }
                        // Metto sullo stack l'indirizzo della prima cella dell'oggetto che ho istanziato
                        push(heapMemoryStart);
                        // A questo punto dovrei aver usato tutta la memoria allocata
                        assert allocatedMemory == null;
                        hp = heap.getNextFreeAddress() > hp ? heap.getNextFreeAddress() : hp;
                        break;
                    case SVMParser.LC:
                        int codeAddress = pop();
                        push(code[codeAddress]);
                        break;
                    case SVMParser.COPY:
                        push(getMemory(sp));
                        break;
                    case SVMParser.HALT:
                        return outputBuffer;
                }
                if (debug) {
                    System.out.println(bytecode + ": ");
                    printMemory();
                }
            }
        } catch (VMOutOfMemoryException | SegmentationFaultException e) {
            outputBuffer.add("Error: " + e.getMessage());
            return outputBuffer;
        }
    }


    private int pop() throws SegmentationFaultException {
        int res = getMemory(sp);
        setMemory(sp++, 0);
        return res;
    }

    private void push(int v) throws VMOutOfMemoryException, SegmentationFaultException {
        if (sp - 1 < hp) {
            throw new VMOutOfMemoryException(VMOutOfMemoryException.OverflowType.STACK);
        }
        setMemory(--sp, v);
    }

}