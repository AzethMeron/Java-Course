# $1 - number of files to generate
# $2 - number of ppl per file
# $3 - directory
# $4 - file with first names
# $5 - file with second names

random() {
	divisor=$(expr $2 - $1 + 1)
	val=$(expr $RANDOM % $divisor + $1)
	echo $val
}

generate() {
	filenum=$1
	pplnum=$2
	dir=$3
	firstnames=$4
	seconnames=$5

	mkdir -p $dir

	for (( i=1; i <=$filenum; i++ ))
	do
		output="File$(printf "%03d" "$i").txt"
		output=$dir'/'$output
		for (( j=1; j <= $pplnum; j++ ))
		do
			shuf -n 1 $firstnames >> $output
			shuf -n 1 $seconnames >> $output
			echo $(random 10 100) >> $output
			echo $(random 21 65) >> $output
			echo "" >> $output
		done
		echo Generated file $output
	done
}

generate $1 $2 $3 $4 $5
