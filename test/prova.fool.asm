push 0
push 1
push 1
push 2
push classCiao
new
push -2
lfp
add
lw
push 2
add
lw
push 1
beq label0
push 6
print
b label1
label0:
push 7
print
label1:
halt

function0:
cfp
lra
push 0
srv
sra
pop
sfp
lrv
lra
js
classCiao:
push function0
