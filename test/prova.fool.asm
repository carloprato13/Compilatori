push 0
push 16
push 1
push classNumero
new
push 1
push 1
push classCiao
new
lfp
push classNumero
push 0
add
lc
js
print
halt

function0:
cfp
lra
push 1
push 1
lfp
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
push 1
push 1
lfp
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

function3:
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
function2
function3
