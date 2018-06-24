push 0
push 1
push 1
push 2
push classCiao
new
lfp
push -2
lfp
add
lw
copy
lw
push 1
add
lc
js
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
push 1
srv
sra
pop
sfp
lrv
lra
js
classCiao:
push function0
