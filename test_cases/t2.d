var sum := 0;
var i, tmp;

for i in 1 .. 10 loop
    tmp := sum;
    sum := tmp + i;
end;

print  sum;