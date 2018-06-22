push 0
push 1
push 1
push classCiao
new
push 1
push 1
beq label0
push 3
b label1
label0:
lfp
push -4
lfp
add
lw
copy
lw
push 0
add
lc
js
label1:
halt

function0:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

function1:
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
