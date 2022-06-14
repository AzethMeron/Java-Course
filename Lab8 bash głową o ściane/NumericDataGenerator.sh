
# $1 filename
# $2 how many numbers
# $3 output file for processing

random() {
	divisor=$(expr $2 - $1 + 1)
	val=$(expr $RANDOM % $divisor + $1)
	echo $val
}

random10digits() {
	echo "$(random 1000 9999)$(random 1000 9999)$(random 10 99)"
}

generate() {
	filename=$1
	num=$2
	for (( i=1; i <=$num; i++ ))
	do 
		echo $(random10digits) >> $filename
	done
}

generate $1 $2

primecheck() {
	num=$1
	for((i=2; i<=num/2; i++))
	do
	  if [ $((num%i)) -eq 0 ]
	  then
	    echo 0
	    exit
	  fi
	done
	echo 1
}

process() {
	filename=$1
	outname=$2
	while IFS= read -r line
	do
		output=$(primecheck $line)
		if [ $output -eq "1" ]; then
			echo $line >> $outname
		fi
	done < "$filename"
}

process $1 $3