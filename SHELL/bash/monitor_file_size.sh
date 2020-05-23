#!/usr/bin/sh
if [ $# != 1 ]
  then
    echo "Usage: monitor_file_size <file_path>"
    exit 1
fi

if [ ! -f $1 ]
  then
    echo "$1 is not exist"
    exit 2
fi

echo -n "start monitor @" > monitor_log
date >> monitor_log

LIMIT=$((1024*1024*20)) # 20M
FILESIZE=0

while [ $FILESIZE -lt $LIMIT ];do
  sleep 1
  FILESIZE=`stat -c%s $1`
done

killall tcpdump
echo -n "stop monitor @" >> monitor_log
date >> monitor_log
