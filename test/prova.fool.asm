push 0
push 12
push 1
push 2
push classCiao
new
push 12
push -2
lfp
add
lw
push 1
add
sw
push 9999
push -2
lfp
add
lw
push 1
add
lw
print
halt

function0:
cfp
lra
push 0
push 0
lfp
lw
lw
add
lw
hoff
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
push 0
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
classNumero:
push function0
push function1
classCiao:
push function0
push function1
push function2
