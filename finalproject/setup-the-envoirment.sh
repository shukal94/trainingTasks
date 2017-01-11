# please, remove the sharp from the following string, 
# if you not sure, that the something from this soft are not installed
sudo apt-get install -y firefox openjdk-8-jdk vagrant maven 

# sets up the VM
cd vagrant-lamp-wordpress-install-wordpress
vagrant up && vagrant ssh
firefox localhost:8888

# now, your VM is installed, then install wordpress on your localhost

# to be continued in test.sh...

