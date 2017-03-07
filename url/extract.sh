#！/bin/bash

less index* | grep -A 3 '<div class="hospital-info"' | sed 's/^.*title="//g' | sed 's/"\>.*title="/ /g' | sed 's/"\>.*title="/  /g' | sed 's/"\>.*$//g' > info_check.txt;
# 将上述片段内的所有信息简要抽取出来，形成一个总的数据库。这个其实是用来检查数据库信息有没有缺的。
less index* | grep '<h3 class="name"' | sed 's/^.*title="//g' | sed 's/"\>.*$//g' > name.txt;
# 抽取所有index.html的医院名称。
less index* | grep '<p class="address"' | sed 's/^.*title="//g' | sed 's/"\>.*$//g' > addr.txt;
# 抽取所有index.html的医院地址。
less index* | grep '<p class="telephone"' | sed 's/^.*title="//g' | sed 's/"\>.*$//g' > tel.txt;
# 抽取所有index.html的医院电话。
less index* | grep '<div class="ys-hospital">' | sed 's/^.*regionId=0"\>//g' | sed 's/\<\/a\>.*$//g' > city.txt;
# 抽取所有index.html的地级市。
less index* | grep '<p class="ys-util-text-smaller ys-util-margin-t9 ys-util-margin-b20">' | sed 's/^.*\<p class="ys-util-text-smaller ys-util-margin-t9 ys-util-margin-b20"\>//g' | sed 's/\<\/p\>.*$//g' > desc.txt;
# 抽取所有index.html的医院描述。
mkdir html
mv index* ./html
mkdir info
mv *.txt ./info
# 归档整理这么多的index.html。