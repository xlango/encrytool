#文件加密工具 <br>
1.DES <br>
  (1)将项目打包为jar <br>
  (2)使用命令行执行jar包： java -jar jar包名  arg[0] arg[1] arg[2]  <br>
  (3)arg为传入main方法的参数，在main方法中调用了加密文件的方法  <br>
  (4)参数： <br>
      ---arg[0]:待加密的文件路径加文件名加文件名，例：D:\tmp\1.zip  <br>
      ---arg[1]:生成目标加密文件的的文件路径加文件名加文件名，例：D:\tmp\2.zip <br>
      ---arg[2]:加密文件自定义密钥，例：1234567  <br>
  (5)打包项目需要注意的问题：打包时MANIFEST.MF不能缺少，使用其中Main-Class: com.encrtool.App  设置主入口类  <br>
  (6)操作示例：<br>
      ![Image text](https://github.com/xx132917/encrytool/blob/master/readme-img/test.png) <br><br>
