push 0
push 16
push 0
push 2
push classCiao
new
lfp
push classCiao
push 0
add
lc
js
print
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
push 0
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
classNumero:
function0
function1
classCiao:
function0
function1
function2
