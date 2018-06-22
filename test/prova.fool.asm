push 0
push 2
push 1
push classNumero
new
push 1
push 0
push 2
push classCiao
new
lfp
push -11
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
push 1
push classNumero
new
nulllfp
push -12
lfp
add
lw
copy
lw
push 2
add
lc
js
push 1
beq label0
lfp
push -12
lfp
add
lw
copy
lw
push 0
add
lc
js
b label1
label0:
lfp
push -11
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
push -10
lfp
add
lw
push 1
push classNumero
new
srv
sra
pop
pop
sfp
lrv
lra
js
