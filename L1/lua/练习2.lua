function fb(i)
	if i<=2 and i>0 then
	return 1
	else
	y=fb(i-1)+fb(i-2)
	return y
	end
end
i=1
for i=1,20 do
print(fb(i))
end

for x=1,9,1 do
	y=""
	for z=1,9,1 do
		if z>=x then
		n=x*z
			if n<9 then
			n="0"..n
			end
		y=y..x.."*"..z.."="..n.." "
	    end
	end
print(y)
end
