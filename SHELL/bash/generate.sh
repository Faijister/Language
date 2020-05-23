#!/bin/bash
if [ $# -ne 2 ]; then
echo "usage: generate ip template";
exit 1
fi
TMPFILENAME=`mktemp /tmp/tmp-sed.XXXX`
outputfile=GED-`echo $2 | awk -F. '{print $1;}'`.conf
cat $1 | while read oneline
do
	[ -z "$oneline" ] && continue
	firstchar=${oneline:0:1}
	if [ $firstchar = "#" ]; then 
		continue 
	fi
        i=`expr index $oneline "="`
        substr1=${oneline:0:$i-1}
        substr2=${oneline:$i}
        echo 's/<'$substr1'>/'$substr2'/g'>>$TMPFILENAME
done

sed -f $TMPFILENAME $2 > $outputfile
echo -e "\033[1m$outputfile\033[0m generated successfully."
exit 0
