push 0
push 1
push 1
push classCiao
new
push 2
push 1
add
push 3
bleq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 3
b label1
label0:
push 0
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
