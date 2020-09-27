var array := [7, 8, 5, 1, 4, 2, 3, 6];
var len := 8;
var maxi := 0;
var mini := 1000;

var i;
for i in 1 .. len loop
    if a[i] > maxi then
    maxi := a[i];
    end;
end;

var j;
for j in 1 .. len loop
    if a[i] < mini then
    mini := a[i];
    end;
end;

print "Maximum number in array is: ";
print maxi;

print "Minimum number in array is: ";
print mini;