def fun = { int x -> println "Number ${x}" }


int a, x, y = 0

x = 0
y = 99

for (i in x..y) {
    a++;
    fun(i);
}

assert a == 123

println(a)
