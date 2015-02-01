package com.mz.youchat.comm;

/**
 * 各个链接url设置地方.
 * User: Lusar
 * Date: 13-11-10
 * Time: 下午3:33
 */    
public class HttpUrl {
    
	
	
	//apk 下载地址
	public static final String  APK			=	"http://app.idoukou.com/download/iDouKou.apk";
	public static final String  CHECK_APK 	= 	"http://api2.idoukou.com/apk.php";
	


	//Xmpp 相关配置 add by lc.
	public static final int 	XMPP_PORT 	=	 5222;
//	public static final String 	XMPP_HOST 	= 	"59.108.38.204";
    public static final String 	XMPP_HOST 	= 	"xmpp.idoukou.com";

//    private static  final  String host = "http://59.108.38.199/rest/api/";

//    public static final String  APK			=	"http://api2.idoukou.com/rest/api/assets/iDouKou.apk";
//    public static final String  CHECK_APK 	= 	"http://api2.idoukou.com/rest/api/apk.php";
    private static  final  String host = "http://api2.idoukou.com/";
//    private static  final  String host = "http://59.108.38.199/rest/api/";
    
    public static final String  LOGIN         	=   host + "user/sign_in";       //@author  lusar 登录
    public static final String  REGISTER     	=   host  + "user/sign_up";      //@author nast 手机号注册
    
    //导师
    public static final String  TEACHER_LIST      				=   host  + "teacher/list";  
    public static final String  TEACHER_WORK_LIST      			=   host  + "teacher/%s/works";  
    public static final String  TEACHER_APPLY      				=   host  + "teacher/apply";  
    
    
    //众筹
    public static final String  WISH_FINISHED      			=   host  + "wish/finished";  
    public static final String  WISH_NOT_FINISHED      		=   host  + "wish/not_finished";  
    public static final String  WISH_CREATE      			=   host  + "wish/create";
    public static final String  WISH_UPDATE      			=   host  + "wish/%s/update";
    public static final String  WISH_INFO      				=   host  + "wish/%s/info";
    public static final String  WISH_COMMENT_LIST      		=   host  + "wish/%s/comment/list";
    public static final String  WISH_COMMENT	      		=   host  + "wish/%s/comment";
    public static final String  WISH_DONATE_FLOW	      	=   host  + "wish/%s/donate/flow";
    public static final String  WISH_DONATE			      	=   host  + "wish/%s/donate";
    public static final String  WISH_APPLY	      			=   host  + "wish/%s/apply";
    public static final String  WISH_POOL_LIST	      		=   host  + "wish/pool/list";
    public static final String  WISH_CATEGORY	      		=   host  + "wish/category";
    
    public static final String  WISH_PRODUCT				=   host  + "wish/%s/product_list";
    
    
    //用户相关接口
    public static final String 	USER_INFO				=	host + "user/%s/info";
    public static final String  USER_LOCATION_UPDATE	= 	host + "user/%s/location/update"; //@author nast 更新用户坐标
    public static final String  USER_GALLERY_LIST		=	host + "gallery/list";		 //相册列表
    public static final String  USER_GALLERY_CREATE		=	host + "gallery/create";		 //创建相册
    public static final String  USER_PHOTO_LIST			=	host + "gallery/%s/photo_list";		 	//照片列表
    public static final String  USER_PHOTO_LAST			=	host + "photo/last";		 	//
    public static final String  USER_PHOTO_CREATE			=	host + "gallery/%s/photo_create";		 	//照片列表
    public static final String  USER_PHOTO_DELETE			=	host + "photo/%s/delete";		 	//删除照片
    public static final String  USER_GET_PASSWORD			=	host + "user/getpassword";		 	//
    public static final String  USER_INFO_UPDATE			=	host + "user/%s/info/update";		 	//
    public static final String  USER_ICON_UPDATE			=	host + "user/%s/icon/update";		 	//
    public static final String  USER_SPACEICON_UPDATE			=	host + "user/%s/spaceicon/update";		 	//
    public static final String  USER_WITH_OPENID			=	host + "user/sign_up_with_openid";		 	//
    
    
    
    //歌曲相关接口
    public static final String MUISC_INFO						=	host + "song/%s/info";
    public static final String MUSIC_BUSINESS_INFO				=	host + "song/%s/businessInfo";
    public static final String MUISC_BUYLIST					=	host + "user/%s/buy_list";
    public static final String MUISC_SONG_LIST					=	host + "song/%s/song_list";
    public static final String MUISC_BUY						=	host + "song/%s/buy";
    public static final String MUISC_COMMENT_LIST				=	host + "song/%s/comment/list";
    public static final String MUISC_COMMENT					=	host + "song/%s/comment";
    public static final String MUISC_PLAY						=	host + "song/%s/play";
    public static final String MUISC_RELEASE					=	host + "song/%s/release";
    public static final String MUISC_FAVORITE_UPDATE			=	host + "song/%s/favorite/update";
    public static final String MUISC_FAVORITE_SONG_LIST			=	host + "user/%s/favorite_song_list";
    public static final String MUISC_VOTE						=	host + "song/%s/vote";
    public static final String MUISC_LIST						=	host + "user/%s/songlist";
    public static final String MUSIC_IS_FAVORITE				=	host + "song/%s/isfavorite";
    
    
    
    //专辑相关接口
    public static final String ALBUM_INFO				=	host + "album/%s/info";
    public static final String ALBUM_LIST				=	host + "user/%s/album_list";
    public static final String ALBUM_SONG_LIST			=	host + "album/%s/song_list";
    public static final String ALBUM_COMMENT_LIST		=	host + "album/%s/comment/list";
    public static final String ALBUM_COMMENT			=	host + "album/%s/comment";
    public static final String ALBUM_RELEASE			=	host + "album/%s/release";
    public static final String ALBUM_CHANGE_FAVORITE	=	host + "album/%s/favorite";
    public static final String ALBUM_FAVORITE_LIST		=	host + "user/%s/favorite_album_list";
    public static final String ALBUM_VOTE				=	host + "album/%s/vote";
    public static final String ALBUM_IS_FAVORITE		=	host + "album/%s/isfavorite";
    
    
    //搜索接口
    public static final String 	SEARCH_NEARBY			=	host + "search/nearby";				//@author nast 附近
    public static final String  SEARCH_GOBAL			=	host + "search/gobal";			//搜索
    
    //排行聚合
    public static final String TOP10 					=	host + "search/top10";
    
    //排行榜
    public static final String TOP99				=	host + "search/top99";
    
    //星工场相关接口
    public static final String  STUDIO_DETAIL				=	host + "studio/%s/info";		//@author nast 录音棚||培训机构详情
    public static final String 	STUDIO_LIST					=	host + "studio/list";				//录音棚列表
    public static final String 	STUDIO_TRAINING_LIST		=	host + "studio/training";				//培训机构列表
    public static final String  STUDIO_DO_COMMENT			=	host + "studio/comment/create";	//评论 录音棚|培训机构
    public static final String  STUDIO_UN_MUSIC_LIST		=	host + "studio/%s/unmusic";	//录影棚当前用户作品
    public static final String  STUDIO_COMMENT				=	host + "studio/%s/comment";	//评论录音棚
    public static final String  STUDIO_COMMENT_LIST			=	host + "studio/%s/comment/list";	//评论列表 （录音棚 || 机构)
    public static final String  STUDIO_APPLY				=	host + "studio/apply";		//申请加入新的录音棚/培训机构
    public static final String  STUDIO_APPLY_JOIN			=	host + "studio/applyjoin";		//申请加入新的录音棚/培训机构
    public static final String  STUDIO_MAP					=	host + "studio/map";		//申请加入新的录音棚/培训机构
    public static final String  STUDIO_SEARCH				=	host + "studio/search";
    
    
    //系统相关接口
    public static final String  BIN_FEEDBACK					=		host + "bin/feedback";		//意见反馈
    public static final String  BIN_SHARE_CONTENT				=		host + "bin/share/content";		//分享文字
    public static final String  BIN_REPORT						=		host + "bin/report";		//举报
    public static final String  BIN_REGIST						=		host + "bin/regist";		//
    public static final String  BIN_STATISTICS						=		host + "bin/statistics";		//
    
    //好友相关接口地址
    public static final String  FRIEND_FOLLOWING_NEWS					=	host + "friend/%s/following/news";
    public static final String  FRIEND_FANS_LIST						=	host + "friend/%s/fans/list";
    public static final String  FRIEND_FOLLOWING_LIST					=	host + "friend/%s/following/list";
    public static final String  FRIEND_FOLLOWINGS_STATE_UPDATE			=   host + "friend/%s/followings/state/update";  	
    public static final String  FRIEND_FOLLOWINGS_STATE					=   host + "friend/%s/followings/state";  	
    
    
    //分组管理
    public static final String  FRIEND_GROUP_LIST						=	host + "friend/group/list";
    public static final String  FRIEND_GROUP_CREATE						=	host + "friend/group/create";
    public static final String  FRIEND_GROUP_UPDATE						=	host + "friend/group/%s/update";
    public static final String  FRIEND_GROUP_DELETE						=	host + "friend/group/%s/delete";
    public static final String  FRIEND_GROUP_CHANGE						=	host + "friend/group/%s/manage";
    
    
    //联系人
    public static final String  CHAT_LAST								=	host + "chat/last";
    public static final String  CHAT_LOG							=	host + "chat/log";
    
    
    //礼物
    public static final String  GIFT_SHELF 						=	host + "gift/shelf";
    public static final String  GIFT_PRESENT 					=	host + "gift/present";
    public static final String  GIFT_BUY	 					=	host + "gift/buy";
    public static final String  GIFT_RECEIVE_LIST	 			=	host + "gift/receive_list";
    
    
    //打赏
    
    public static final String  REWARD_LIST						=	host + "reward/list";
    public static final String  REWARD_INFO						=	host + "reward/info";
    public static final String  REWARD_DO_REWARD				=	host + "reward/doreward";
    public static final String  REWARD_SEEK						=	host + "reward/%s/seek";
    public static final String  REWARD_SWITCH					=	host + "reward/%s/switch";
    public static final String  REWARD_INCOME					=	host + "reward/%s/income";
    public static final String  REWARD_RECORD_LIST				=	host + "reward/%s/record";
    
    //帐户
    
    public static final String  ACCOUNT_SUMMARY					=	host + "account/%s/summary";
    public static final String  ACCOUNT_FLOW					=	host + "account/%s/flow";
    public static final String  ACCOUNT_BALANCE					=	host + "account/%s/balance";
    
    
    //播放列表
    
    public static final String  PLAYLIST_CREATE					=	host + "playlist/create";
    public static final String  PLAYLIST_LIST					=	host + "playlist/list";
    public static final String  PLAYLIST_RENAME					=	host + "playlist/%s/rename";
    public static final String  PLAYLIST_DELETE					=	host + "playlist/%s/delete";
    public static final String  PLAYLIST_SONG_LIST				=	host + "playlist/%s/list";
    public static final String  PLAYLIST_MANAGE					=	host + "playlist/%s/manage";
    
    //广告
    public static final String  AD_BANNERS 						=		host + "ad/android" ;
}
