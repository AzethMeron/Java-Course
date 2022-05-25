#/!bin/bash

mkdir -p $1

dir1=$1"/dir1"
dir2=$1"/dir2"
mkdir -p $dir1
mkdir -p $dir2

dir1file1=$dir1"/file1"
dir1file2=$dir1"/file2"
dir1file3=$dir1"/file3"
echo $RANDOM >> $dir1file1
echo $RANDOM >> $dir1file2
echo $RANDOM >> $dir1file3
chmod -w $dir1file1
chmod -w $dir1file2
chmod 777 $dir1file3

dir2file1=$dir2"/file1"
dir2file2=$dir2"/file2"
dir2file3=$dir2"/file3"
echo $RANDOM >> $dir2file1
echo $RANDOM >> $dir2file2
echo $RANDOM >> $dir2file3
chmod -w $dir2file1
chmod -w $dir2file2
chmod 777 $dir2file3