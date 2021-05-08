package com.example.administrator.mylife.http;

/**
 * Created by Administrator on 2016/4/1.
 */
public class HttpCommons {
    /**
     * 固件版本升级的url
     */
//    public static final String UPER_VERSION_URL = "http://otatest.etuchina.com";
    public static final String BASE_URL = "http://test.etuchina.com/";
    public static final String UPER_VERSION_URL = "http://ota.etuchina.com";
//    public static final String BASE_URL = "http://api.etuchina.com/";


    public static final String API_RE_LOGIN = BASE_URL + "index.php?m=Api&c=User&a=relogin";
    public static final String API_REG_CODE = BASE_URL + "index.php?m=Api&c=User&a=sendRegCode";
    public static final String API_PWD_CODE = BASE_URL + "index.php?m=Api&c=User&a=sendPwdCode";
    public static final String API_REG_CODECHECK = BASE_URL + "index.php?m=Api&c=User&a=checkRegCode";
    public static final String API_CHECK_PWDCODE = BASE_URL + "index.php?m=Api&c=User&a=checkPwdCode";
    public static final String API_REG = BASE_URL + "index.php?m=Api&c=User&a=register";
    public static final String API_FINDPWD = BASE_URL + "index.php?m=Api&c=User&a=findPwd";
    public static final String API_REG_INFO = BASE_URL + "index.php?m=Api&c=User&a=registerbase";
    public static final String API_USER_UPDATE_AVATAR = BASE_URL + "index.php?m=Api&c=User&a=updateAvater";
    public static final String API_USER_UPDATE_SEX = BASE_URL + "index.php?m=Api&c=User&a=updateSex";
    public static final String API_USER_UPDATE_HEIGHT = BASE_URL + "index.php?m=Api&c=Health&a=healthUpdate_height";
    public static final String API_USER_UPDATE_WEIGHT = BASE_URL + "index.php?m=Api&c=Health&a=healthUpdate_weight";
    public static final String API_USER_UPDATE_AGE = BASE_URL + "index.php?m=Api&c=User&a=updateBirthday";
    public static final String API_USER_UPDATE_STEP = BASE_URL + "index.php?m=Api&c=Health&a=healthUpdate_step";
    public static final String API_USER_UPDATE_NICKNAME = BASE_URL + "index.php?m=Api&c=User&a=updateNickname";
    public static final String API_CITIZEN_CARD_BALANCE = BASE_URL + "index.php?m=Api&c=Citizencard&a=getCitizencardBalance";
    public static final String API_USER_SHARE_SPORT = BASE_URL + "index.php?m=Api&c=Share&a=share";

    public static final String API_UPDATE_PWD = BASE_URL + "index.php?m=Api&c=User&a=updatePwd";

    //支付
    //发起支付宝支付订单
    public static final String API_ORDER_CREAT = BASE_URL + "index.php?m=pay&c=Alipay&a=orderCreat";
    //获取用户充值订单列表
    public static final String API_ORDER_LIST = BASE_URL + "index.php?m=pay&c=Xzcard&a=orderList";
    //向徐州发起入账请求
    public static final String API_ADD_ORDER = BASE_URL + "index.php?m=pay&c=Xzcard&a=addOrder";


    //用户登录
    public static final String API_LOGIN = BASE_URL + "index.php?m=Api&c=User&a=login";
    //计步数据获取
    public static final String API_USER_STEP_INFO = BASE_URL + "index.php?m=Api&c=Health&a=stepsMonitor";
    //首页推荐列表获取
    public static final String FEED_INDEX_LISTS = BASE_URL + "index.php?m=Feed&c=index&a=home";
    //获取文章详情
    public static final String FEED_INDEX_SHOW = BASE_URL + "index.php?m=Feed&c=Index&a=getFeed";
    //获取评论列表
    public static final String FEED_INDEX_COMMENTIST = BASE_URL + "index.php?m=Feed&c=Index&a=commentList";
    //发布评论
    public static final String FEED_ADD_COMMENT = BASE_URL + "index.php?m=Feed&c=Index&a=addComment";
    //删除评论
    public static final String FEED_DE_COMMENT = BASE_URL + "index.php?m=Feed&c=Index&a=deComment";
    //获取用户具体提醒总个数
    public static final String TASK_INDEX_USERDATANUM = BASE_URL + "index.php?m=Task&c=Index&a=getUserDataNum";
    //获取用户具体提醒个数
    public static final String TASK_INDEX_USERDATANUM_LIST = BASE_URL + "index.php?m=Task&c=Index&a=getUserDataNumList";
    //最新动态列表
    public static final String FEED_INDEX_NEWS = BASE_URL + "index.php?m=Feed&c=index&a=news";
    //点赞/取消点赞
    public static final String API_ADS_ZAN = BASE_URL + "index.php?m=Api&c=Ads&a=zan";
    //获取用户信息
    public static final String API_USER_INFO = BASE_URL + "index.php?m=Api&c=User&a=getUserInfo";
    //获取任务列表
    public static final String TASK_INDEX_LIST_TASK = BASE_URL + "index.php?m=Task&c=Index&a=listTask";
    //签到接口
    public static final String TASK_INDEX_CHECKIN = BASE_URL + "index.php?m=Task&c=Index&a=checkIn";
    //获取用户积分列消息表
    public static final String TASK_INDEX_LIST_USERCREDIT = BASE_URL + "index.php?m=Task&c=Index&a=listUserCredit";
    //获取指定uid点赞消息表
    public static final String FEED_INDEX_MYDIGG = BASE_URL + "index.php?m=Feed&c=Index&a=mydigg";
    //获取用户积分
    public static final String TASK_INDEX_USERCREDIT = BASE_URL + "index.php?m=Task&c=Index&a=getUserCredit";
    //获取我的列表
    public static final String FEED_INDEX_MYLIST = BASE_URL + "index.php?m=Feed&c=Index&a=mylist";
    //获取标签
    public static final String FEED_INDEX_GETLABEL = BASE_URL + "index.php?m=Feed&c=index&a=getLabel";
    //上传图片
    public static final String FEED_INDEX_UPLOAD = BASE_URL + "index.php?m=Feed&c=index&a=upload";
    //发表游记
    public static final String FFED_INDEX_ADD_FEED = BASE_URL + "index.php?m=Feed&c=index&a=addFeed";
    //删除游记（删除文章）
    public static final String FEED_INDEX_DE_FEED = BASE_URL + "index.php?m=Feed&c=index&a=deFeed";
    //修改头像
    public static final String API_CHANGE_AVATAR = BASE_URL + "index.php?m=Api&c=User&a=updateAvater";
    //睡眠数据获取
    public static final String API_USER_SLEEP_INFO = BASE_URL + "index.php?m=Api&c=Health&a=sleepMonitor";
    //验证卡号有效性
    public static final String API_CHECK_CARD = BASE_URL + "index.php?m=pay&c=Xzcard&a=checkCard";
    //手环写入情况返回
    public static final String API_RETURN_BAND = BASE_URL + "index.php?m=pay&c=Xzcard&a=returnBand";
    //发起徐州专有账户充值订单生成
    public static final String API_ADDORDER = BASE_URL + "index.php?m=pay&c=Xzpay&a=addOrder";
    //专有账户圈存订单支付
    public static final String API_PAYORDER = BASE_URL + "index.php?m=pay&c=Xzpay&a=payOrder";
    //获取客服号码
    public static final String API_GET_KFPHONE = BASE_URL + "index.php?m=pay&c=Xzcard&a=getKFPhone";
    //记步数据提交
    public static final String API_STEPS_UPLOAD = BASE_URL + "index.php?m=Api&c=Health&a=stepsUpload";
    //睡眠数据提交
    public static final String API_SLEEP_UPLOAD = BASE_URL + "index.php?m=Api&c=Health&a=sleepUpload";
    //获取更新次数
    public static final String API_GET_TIMES = BASE_URL + "index.php?m=Api&c=Health&a=getTimes";
    //问题反馈
    public static final String API_FEED_BACK = BASE_URL + "index.php?m=Api&c=Feedback&a=feedback";
    //绑定手环前，验证手环是否被绑定
    public static final String API_ISBAND_BINGING = BASE_URL + "index.php?m=Api&c=User&a=isBandbinging";
    //解除手环绑定
    public static final String API_UNBINDING_BAND = BASE_URL + "index.php?m=Api&c=User&a=unbindingBand";
    //绑定手环时候，上传mac
    public static final String API_BINDING_BAND = BASE_URL + "index.php?m=Api&c=User&a=bindingBand";
    //易途重新请求mac2
    public static final String API_RE_GET_MAC = BASE_URL + "index.php?m=pay&c=Order&a=reGetMac2";
    //获得卡内交易的说明
    public static final String API_GET_CARD_DESC = BASE_URL + "index.php?m=Pay&c=Order&a=tips";
    //获取积分商品列表
    public static final String MALL_GET_SCORE_GOOD_LIST = BASE_URL + "index.php?m=mall&c=cmall&a=cmalllsts";
    //积分消费记录
    public static final String MALL_SCORE_CONSUME_RECORD = BASE_URL + "index.php?m=mall&c=cmall&a=cmallconsume";
    //获取广告位
    public static final String GET_ADS = BASE_URL + "index.php?m=api&c=ads&a=ads";
    //积分商品兑换确认
    public static final String SCORE_CONSUME_CONFIRM = BASE_URL + "index.php?m=Mall&c=Cmall&a=cmallbuyconfirm";
    //校验积分商品是否可以购买
    public static final String CHECK_CAN_BUY = BASE_URL + "index.php?m=Mall&c=Cmall&a=cmallgobuy";
    //积分购买商品
    public static final String SCORE_BUY = BASE_URL + "index.php?m=Mall&c=Cmall&a=cmallbuy";
    //查询收获地址
    public static final String SER_USER_ADDRESS = BASE_URL + "index.php?m=Api&c=Address&a=lists";
    //设置默认地址
    public static final String SET_DEFAULT_ADDRESS = BASE_URL + "index.php?m=Api&c=Address&a=setdefault";
    //增加收货地址
    public static final String ADD_ADDRESS = BASE_URL + "index.php?m=Api&c=Address&a=addnew";
    //编辑收货地址
    public static final String EDIT_ADDRESS = BASE_URL + "index.php?m=Api&c=Address&a=edit";
    //删除收货地址
    public static final String DEL_ADDRESS = BASE_URL + "index.php?m=Api&c=Address&a=del";
    //商品详情
    public static final String SCORE_SHOP_DETAIL = BASE_URL + "index.php?m=Index&c=Cmall&a=detail&id=";
    //获取城市
    public static final String SER_CITYS = BASE_URL + "index.php?m=Api&c=Address&a=getarea";
    //获取单条收货地址
    public static final String SER_ADDRESS_DETAIL = BASE_URL + "index.php?m=Api&c=Address&a=detail";
    //判断送货地址是否可以添加
    public static final String ADDRESS_LIMIT = BASE_URL + "index.php?m=Api&c=Address&a=addresslimit";
    //获取连续签到天数
    public static final String GET_CHECK_DAY = BASE_URL + "index.php?m=Task&c=Index&a=getUserCheckDay";
    //检查app版本更新
    public static final String API_APP_UPLOAD = BASE_URL + "index.php?m=Api&c=Version&a=androidappversion";
    //兑换积分获取提示语提示能兑换多少
    public static final String GET_CREDIT_TIPS = BASE_URL+"index.php?m=Task&c=Index&a=getUserCreditTip";
    //兑换红包
    public static final String SEND_RED_BAG = BASE_URL + "index.php?m=Pay&c=Redbag&a=sendRedbag";
    //绑定市民卡卡号
    public static final String BIND_CITY_CARD = BASE_URL + "index.php?m=Api&c=Citizencard&a=bindCitizencardno";
    //获取积分说明文字
    public static final String GET_CREDIT_DES = BASE_URL + "index.php?m=Task&c=Index&a=getCreditDes";
    //获取开始loading页图片
    public static final String GET_BINNER = BASE_URL + "index.php?m=Api&c=Banner&a=banner";
    //获取积分排名分享的信息
    public static final String SCORE_RAKING_SHARE = BASE_URL + "?m=api&c=user&a=wxShare";
    //获取今日运动信息
    public static final String GET_TODAY_SPORT_INFO = BASE_URL + "index.php?m=Api&c=Health&a=stepsTodayInfo";
    /**
     * 获取城市天气信息
     */
    public static final String GET_CITY_WEATHER_INFO = BASE_URL + "index.php?m=Api&c=Api&a=weather";
    /**
     * 获取当日签到状态
     */
    public static final String GET_SIGN_STATUS = BASE_URL + "index.php?m=Api&c=User&a=getSignStatus";
    /**
     * 公交查询
     */
    public static final String GET_BUS = BASE_URL + "index.php?m=Api&c=Api&a=bus";
    /**
     * 问题查询
     */
    public static final String GET_QUESTIONS = BASE_URL + "index.php?m=Api&c=Doc&a=qa";
    /**
     * 单个问题查询（需要拼接id）
     */
    public static final String GET_ITEM_QUESTION = BASE_URL + "index.php?m=index&c=document&a=qad&id=";
    /**
     * 查询客服电话
     */
    public static final String GET_PHONE_NUMBER = BASE_URL + "index.php?m=Api&c=Api&a=customer";
    /**
     * 获取微信分享运动信息
     */
    public static final String GET_SHARE_USER_INFO = BASE_URL + "index.php?m=Api&c=Share&a=shareuserinfo";
    /**
     * 第三方登陆
     */
    public static final String PLAT_FROM_LOGIN = BASE_URL + "index.php?m=Api&c=Oauth&a=oauthLogin";
    /**
     * 完善第三方注册
     */
    public static final String PLAT_FORM_REGISTER = BASE_URL + "index.php?m=Api&c=Oauth&a=oauthUpdate";
    /**
     * 綁定已有账户
     */
    public static final String PLAT_FORM_BIND = BASE_URL + "index.php?m=Api&c=Oauth&a=initOauthUser";
    /**
     * APP首页地址
     */
    public static final String APP_INDEX = BASE_URL + "index.php?m=Index&c=App&a=index";
    /**上传消费记录*/
    public static final String UPDATE_RECORD_DATA = BASE_URL + "index.php?m=api&c=card&a=consumption";

    /**
     * 手环购买
     */
    public static final String BUY_LINK = BASE_URL+ "index.php?m=Api&c=Api&a=buyLink";

    /**
     * 功能开关
     */
    public static final String IS_USED = BASE_URL + "index.php?m=Api&c=Api&a=isUsed";

    /**
     * 分享背景颜色
     */
    public static final String SHARE_BG = BASE_URL + "index.php?m=Api&c=share&a=sharebg";

}
