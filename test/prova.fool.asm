push 0
push 2
push 1
push 2
push classCiao
new
lfp
push -10
lfp
add
lw
copy
lw
push -1
add
lc
js
push 1
beq label0
push 6
b label1
label0:
push 7
label1:
halt

function0:
cfp
lra
push 0
lfp
lw
lw
add
lw
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
push 1
srv
sra
pop
sfp
lrv
lra
js

function2:
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

function3:
cfp
lra
push 4
push 1
push classNumero
new
srv
sra
pop
sfp
lrv
lra
js
classNumero:
push function0
push function1
classCiaone:
push function0
push function1
push function2
push function3
classCiao:
push function0
push function1
push function2
