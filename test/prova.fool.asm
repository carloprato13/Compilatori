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
push -6
lfp
add
lw
copy
lw
push 1
add
lc
js
lfp
push -6
lfp
add
lw
copy
lw
push 0
add
lc
js
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
