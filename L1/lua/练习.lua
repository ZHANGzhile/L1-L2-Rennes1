function shushu()
	print("张知乐")
end
shushu()


function cang(i)
    print(i)
end
do
jj = "zhile"
cang(jj)
end


function hs(a,b)
    x=a+a
	y=b+b
	return x,y
end
i=10
j=11
f1,f2 = hs(i,j)
print(f1.. "et"..f2)

function zhang(a,b)
	i=a + b
	j=a - b
	z = a/b
	return i,j,z
end
x=2
y=7
f1,f2,f3 = zhang(x,y)
print(f1.."et"..f2.."et"..f3)



function ys(i)
    if i == 7 then
	    x=""
		y="dyht"
		return x,y
		else
		z = "dyhtszd"
		return z
    end
end
print(ys(7))
print(ys(2))

local i = 25
while i >=3 do
    if i % 2==0 then
    print(i)
	end
i = i - 1
end

local i = 25
while i >= 3 do
    if i % 2==0 then
    print(i.."est un nombre pair")
    else
	print(i,"est un nombre impair")
	end
i = i - 1
end




function ys(x)
    if x =="cang" then
    print("ÄãºÍ²Ø")
    else
    print("ÄãÊäÈëÁË£»", x )
	end
end
a="zh"
ys(a)


for i= 1,10,1 do
if i==7 then
break
end
print ("ÕâÊÇµÚ"..i.."´ÎÑ­»·")
end


for i=1,4,1 do
	for j=1,4,1 do
		for p=1,4,1 do
			if i~=j and i~=p and j~=p then
			print(i..j..p)
			end
		end
	end
end

function fb(i)
	if i <=2 and i>0 then
	return 1
	else
	local y= fb(i-1)+ fb(i-2)
	return y
	end
end
i=1
while i <= 20 do
print(fb(i))
i=i+1
end


for x=1,7,1 do
	j=""
	for y=1,7,1 do
		if y<=x then
		j=j.."*"
		end
	end
	print(j)
end


