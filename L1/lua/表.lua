function F(...)
	arg={...}
	for i=1,#arg do
	print(arg[i])
	end
end
F(1,2,12,true)

function F1(a)
return function(b)
	return a+b
	end
end
F2=F1(2)
print(F2(5))

function F1(a)
return function(b)
      return a/b
      end
end
F2=F1(2)
print(F2(5))



T={1,2,3,4}
for i=1,#T do
	T[i] = T[i]..' true'
	print(T[i])
end

print(12345+6789)

print('je suis '..'etudiant')

print('hello world')

for i=3,25 do
	if i%2 == 0 then 
	    print(i..' est pair')
    else
        print(i..' est impair')
    end
end
print("xxxxxxxxxxxxxxxxxxxxx分割xxxxxxxxx")