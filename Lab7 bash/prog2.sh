#/!bin/bash
  
# loop through all files in current directory
for file in $1/*
do
	# check if it is a file
	if [ -f $file ]
	then
		# check if it has execute permission
		if [ -x $file ]
		then
			# print the complete file name with -l option
			ls -l $file
		fi
	fi
done
