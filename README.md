# LoadingHelper


## 一键切换状态布局

### 下载

`   直接clone代码到本地，再导入Module
    有java版本和kotlin两种版本
    导入对应的一种即可
` 

### 用法

##### 1.获取对象  
`
  LoadingHelper mLoadingHelper = LoadingHelper.with(view);
`
##### 2.切换对应布局

 - ` mLoadingHelper.showOrigin()   //原布局 `
 - ` mLoadingHelper.showLoading()  //加载中布局 `
 - ` mLoadingHelper.showEmpty()    //数据为空布局 `
 - ` mLoadingHelper.showError()    //数据加载失败 `
 - ` mLoadingHelper.showNoNetwork()//无网络布局 `

##### 3.相关配置

 - ` 1. 在初始化的时候传入Config : new Config.Builder().build()`
 - ` 2. 使用自定义布局  mLoadingHelper.putCustomViewByStatus(Status status, View view)`

