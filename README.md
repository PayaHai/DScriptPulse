# DScriptPulse
> MinecraftJava Paper 服务器 JS 脚本引擎

### 介绍
本引擎作为一个中间层，允许您通过 JavaScript 语言来编写 Paper 服务器插件，并且可以通过调用间歇泉的 API 发送基岩版表单。  
您可以将本引擎看做是对 [LLSE](https://github.com/LiteLDev/LegacyScriptEngine) 的模仿，当前，目前的 API 和功能要远少于 [LLSE](https://github.com/LiteLDev/LegacyScriptEngine)。  
目前，本引擎仍处于开发阶段，请勿用于生产环境。

### 安装
1. 下载 [DScriptPulse](https://github.com/PayaHai/DScriptPulse/releases/latest) 最新版。
2. 将其置于 [Paper](https://papermc.io/) 服务端 Plugins 目录下。
3. 启动服务端。

### 脚本插件开发
1. 创建一个文件夹，并将重命名为您插件的名称。
2. 创建 plugin.yml 并写入如下内容：
```yaml
name: <插件名称>
main: main.js # 插件主类名
```
3. 创建一个 main.js 并根据 [文档](https://wiki.dzdstudo.cn/zh/DScriptPulse) 编写插件代码。
>main.js 是插件主类，它必须存在，否则插件将无法加载。您可以根据喜好命名它，但是它必须和 plugin.yml 中的 main 值一致。
4. 将您的插件文件和 plugin.yml 使用 ZIP 格式压缩为一个文件，并将其后缀改为 .sar。
5. 将 .sar 文件置于 plugins 目录下。
6. 启动服务器，脚本插件即可成功加载。

### 最后
- 本引擎根据 GPL-3.0 协议开源，您可以自由使用、修改、分发本引擎。