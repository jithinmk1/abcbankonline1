#clean current process running on 9090
echo "killing current process running on 9090..."
fuser -n tcp -k 9090

#test comment to test the auto builds
echo "Test# 30"

#sleep for 10 seconds to kill the process
sleep 10

#clean temporary gradle directory
echo "Removing temporary gradle directory..."
rm -rf .gradle

#run spring boot in background
echo "Running gradle script to build the project..."
cd /var/lib/jenkins/workspace/abcbankingonline
nohup gradle bootRun >> /tmp/bootRun.log 2>&1 &
© 2020 GitHub, Inc.