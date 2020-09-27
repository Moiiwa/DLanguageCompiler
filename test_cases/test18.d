var array := [5, 75, 58, 7, 1, 9];
var len = 6;

var i, j;
for i in 1 .. len - 1 loop
    for j in 1 .. len - i loop
        if a[j + 1] > a[j] then
            var tmp := a[j];
            a[j] := a[j + 1];
            a[j + 1] := a[j];
        end;
    end;
end;

print "array:\n";
for i in 1 .. len loop
    print a[i], " ";
end;