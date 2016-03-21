package com.mine.testmodel;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.ads8.util.PointsManager.OnPointsSpendListener;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;
import com.baidu.ops.appunion.sdk.AppUnionSDK;
import com.bb.dd.BeiduoPlatform;
import com.bb.dd.listener.IReduceListener;
import com.datouniao.AdPublisher.AppConfig;
import com.datouniao.AdPublisher.SpendNotifier;
import com.dyk.hfsdk.ui.Access;
import com.jd.callback.JdAddScoreListener;
import com.jd.callback.JdSpendScoreListener;
import com.jd.integral.JdAdManager;
import com.jy.func.JYOfferWall;
import com.jy.func.lner.CheckPointListener;
import com.kaixinduu.DevInit;
import com.kaixinduu.SpendMoneyListener;
import com.lerdian.search.SearchManger;
import com.lerdian.startmanager.EarnPointSun;
import com.lerdian.startmanager.WallUser;
import com.mdxx.fangjinguo.MPMan;
import com.winad.android.offers.AddScoreListener;
import com.winad.android.offers.SpendScoreListener;
import com.yql.dr.sdk.DRScoreInterface;
import com.yql.dr.sdk.DRSdk;
import com.zy.phone.SDKInit;
import com.zy.phone.net.Integral;

import net.midi.wall.sdk.AdWall;
import net.midi.wall.sdk.IAdWallShowAppsNotifier;
import net.midi.wall.sdk.IAdWallSpendPointsNotifier;
import net.youmi.android.AdManager;
import net.youmi.android.offers.OffersManager;
import net.youmi.android.offers.PointsManager;

import org.json.JSONObject;

import java.util.Random;

import cn.dow.android.DOW;
import cn.dow.android.listener.DLoadListener;
import cn.dow.android.listener.DataListener;
import cn.guomob.android.intwal.GMScoreCallBack;
import cn.guomob.android.intwal.GMScoreManager;
import cn.guomob.android.intwal.GMScoreManagerCallBack;
import cn.guomob.android.intwal.OpenIntegralWall;
import cn.waps.AppConnect;
import cn.waps.UpdatePointsNotifier;

//import com.ads8.util.PointsManager;

public class AdvertisingUtils {
	/**
	 * 
	 * @author DDstar 有米积分墙
	 */
	public static class YouMiAd {
		private AdManager adManager;
		private Context context;
		private Activity activity;
		private OffersManager offersManager;

		// 权限
		/**
		 * 复制方法 1 选中所有权限; 2 ctrl + / 解除注释模式 ;3 ctrl+ c 复制 ;4 ctrl+ / 再次注释
		 */
//		 <uses-permission android:name="android.permission.INTERNET" />
//		 <uses-permission android:name="android.permission.READ_PHONE_STATE"
//		 />
//		 <uses-permission
//		 android:name="android.permission.ACCESS_NETWORK_STATE" />
//		 <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
//		 />
//		 <uses-permission
//		 android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
//		 <uses-permission
//		 android:name="android.permission.SYSTEM_ALERT_WINDOW" />
//
//		 <!-- 如果使用积分墙广告,还需要配置下面权限 -->
//		 <uses-permission android:name="android.permission.GET_TASKS" />
//		 <uses-permission
//		 android:name="android.permission.PACKAGE_USAGE_STATS"
//		 tools:ignore="ProtectedPermissions" />
//
		// <!-- 以下为可选权限 -->
		// <uses-permission
		// android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
		// <uses-permission
		// android:name="android.permission.ACCESS_FINE_LOCATION" />
		// 当配置权限 android.permission.PACKAGE_USAGE_STATS 时，还需要在 manifest
		// 标签中配置下面内容 xmlns:tools="http://schemas.android.com/tools"
		// 其他

		// 积分墙界面
//		 <activity
//		 android:name="com.mdxx.fangjinguo.MDActivity"
//		 android:excludeFromRecents="true"
//		 android:exported="true" >
//		 </activity>
//		 <activity
//		 android:name="com.mdxx.fangjinguo.MLActivity"
//		 android:configChanges="orientation|screenSize|keyboardHidden"
//		 android:excludeFromRecents="true"
//		 android:exported="true" >
//		 </activity>
//		 <activity
//		 android:name="com.mdxx.fangjinguo.MHActivity"
//		 android:configChanges="orientation|screenSize|keyboardHidden"
//		 android:excludeFromRecents="true"
//		 android:exported="true" >
//		 </activity>
//
//		 <service android:name="com.mdxx.fangjinguo.MOService" />
//		 <activity
//		 android:name="net.youmi.android.AdBrowser"
//		 android:configChanges="keyboard|keyboardHidden|orientation|screenSize"
//		 android:theme="@android:style/Theme.Light.NoTitleBar" >
//		 </activity>
//		 <service
//		 android:name="net.youmi.android.AdService"
//		 android:exported="false" >
//		 </service>
//		 <service
//		 android:name="net.youmi.android.ExpService"
//		 android:exported="false" >
//		 </service>
//		 <receiver
//		 android:name="net.youmi.android.AdReceiver" >
//		 <intent-filter>
//		 <action android:name="android.intent.action.PACKAGE_ADDED" />
//		 <data android:scheme="package" />
//		 </intent-filter>
//		 </receiver>
//		 <meta-data
//		 android:name="YOUMI_CHANNEL"
//		 android:value="这里替换为非负整数的渠道号" >
//		 </meta-data>

		// 渠道号列表
		// Android Market market 10000
		// 安智市场 goapk 10010
		// 机锋市场 gfan 10020
		// 安卓市场 hiapk 10030
		// 联想市场 lenovo 10040
		// 应用汇 appchina 10050
		// N多市场 nduoa 10060
		// 木蚂蚁市场 mumayi 10070
		// 爱米软件商店 aimi8 10080
		// 安卓星空 star 10090
		// 乐语 leyu 10100
		// 91手机商店 91sj 10110
		// 优亿市场 eoemarket 10120
		// 移动MM mmarket 10130
		// 3G安卓市场 3g 10140
		// 安丰下载 anfone 10150
		// 安机市场 anshouji 10160
		// 历趣市场 liqu 10170
		// hot市场 592ppc 10180
		// 360软件下载 360cn 10190
		// XDA市场 xda 10200
		// 巴士商店 tgbus 10210
		// 华为智汇云 huawei 10220
		// 天翼空间 189works 10230
		// 联通沃商店 wo 10240
		// UC/天网 uc 10250
		// 地瓜游戏 digua 10260
		// 千尺下载 qianchi 10270
		// 魅族商店 meizu 10280
		// OPPO商店 oppo 10290
		// 十字猫 crossmo 10300
		// 摩托罗拉智件园 motorola 10310
		// 机客商店 159com 10320
		// htc商店 htc 10330
		// 南山市场/泡椒 nanshan 10340
		// 中兴智酷 zhiku 10350
		// 腾讯应用中心 tap 10360
		// 搜狐下载 sohu 10370
		// 网易应用 163 10380
		// 酷安网 coolapk 10390
		// 九游网 9game 10400
		// 乐逗空间 idreamsky 10410
		// 民信中通 minxin 10420
		// 17vee体感游戏 17vee 10430
		// MIUI市场 xiaomi 10440
		// 偶玩游戏 owan 10450
		// 海信 haisense 10980
		// 有米预留1 youmi 10990
		// AdView adview 11010
		// 无极道 wujidao 11020

		public static YouMiAd getInstance(Context context) {
			return new YouMiAd(context);
		}

		public void initSDK(String appId, String appSecret) {
			adManager.init(appId, appSecret, false);
		}

		public void initSDKAndOffWall(String appId, String appSecret) {
			adManager.init(appId, appSecret, false);
			this.offersManager = OffersManager.getInstance(context);
			offersManager.onAppLaunch();
		}

		public void consumeScore() {
			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			ImageView imaTree = (ImageView) view.findViewById(R.id.imageView1);
			Random random = new Random();
			int nextInt = random.nextInt(2);
			if (nextInt == 1) {
				imaTree.setImageResource(R.drawable.cat);
			} else {
				imaTree.setImageResource(R.drawable.money_tree);
			}
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					int inputScore = Integer.valueOf(string);
					boolean isSuccess = PointsManager.getInstance(context)
							.spendPoints(inputScore);
					if (isSuccess) {
						Toast.makeText(context, "积分消费成功", Toast.LENGTH_LONG)
								.show();
					} else {
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
					}
				}
			});
		}

		public void showYouMiOffWall() {
			offersManager.showOffersWall();
		}

		public void exitOffWall() {
			offersManager.onAppExit();
		}

		private YouMiAd(Context context) {
			this.adManager = AdManager.getInstance(context);
			this.context = context;
			this.activity = (Activity) context;
			String mdId = "9b151acaf825b0d0abc1a792889b7117";
			MPMan yoPan = MPMan.getInstance(context);
			yoPan.setKey(context, mdId);
			yoPan.setChannel(context, "fjg");
			yoPan.getMessage(context, true);
		}
	}

	/**
	 * 
	 * @author DDstar 多盟积分墙
	 */
	public static class DMobAd {
		private DOW mDow;
		Context context;
		Activity activity;
		private Handler handle;

		// 权限
		// <uses-permission
		// android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.GET_TASKS" />
		// <uses-permission
		// android:name="android.permission.PROCESS_OUTGOING_CALLS" />
		//
		// 其他
		// <activity
		// android:name="cn.dow.android.DActivity"
		// android:screenOrientation="portrait" />
		// <service android:name="cn.dow.android.DService" />
		// <meta-data
		// android:name="D_PPID" android:value="96ZJ2xZwzeDzPwTBK+" />
		public void initSDK() {
			mDow.init();
			initHandle();
		}

		public void initSDK(String userid) {
			mDow.init(userid);
			initHandle();
		}

		public void initSDK(String userid, DLoadListener listener) {
			mDow.init(userid, listener);
			initHandle();
		}

		public static DMobAd getInstance(Context context) {
			return new DMobAd(context);
		}

		public void show() {
			mDow.show(context);
		}

		public void consumeScore() {
			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String string = etScore.getText().toString();
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					int inputScore = Integer.valueOf(string);
					msg = Message.obtain();
					mDow.consumePoints(inputScore, new DataListener() {

						@Override
						public void onResponse(Object... point) {
							// 积分消费的状态
							Integer status = (Integer) point[0];
							// Toast.makeText(context, "status = " + status,
							// Toast.LENGTH_LONG).show();
							// 用户总的积分数
							Double totalPoint = (Double) point[2];
							// 用户的已消费积分数
							Double consumPoint = (Double) point[1];
							// 用户的剩余积分数
							double lastPoint = totalPoint - consumPoint;
							switch (status) {
							case 1: // 消费成功
								String str = "总积分:" + totalPoint + "\n已消费积分:"
										+ consumPoint + "\n剩余积分：" + lastPoint;
								msg.what = 1;
								msg.obj = str;
								// Toast.makeText(context, str,
								// Toast.LENGTH_LONG)
								// .show();
								break;
							case 4: // 积分不足，消费失败
								// 积分不变
								msg.what = 0;
								msg.obj = "积分不足，消费失败";
								// Toast.makeText(context, "积分不足，消费失败",
								// Toast.LENGTH_LONG).show();
								break;
							case 3: // 订单重复
								// 积分不变
								Toast.makeText(context, "订单重复",
										Toast.LENGTH_LONG).show();
								break;
							}
							handle.sendMessage(msg);
						}

						@Override
						public void onError(String arg0) {
							// TODO Auto-generated method stub
							Toast.makeText(context, arg0, Toast.LENGTH_LONG)
									.show();
						}
					});
					// alertDialog.dismiss();
				}
			});
			// TODO Auto-generated method stub
		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}

		private DMobAd(Context context) {
			this.mDow = DOW.getInstance(context);
			this.context = context;
			this.activity = (Activity) context;
		}
	}

	/**
	 * 
	 * @author DDstar 金袋积分墙
	 *
	 */
	public static class JDAd {
		private Context context;
		private Activity activity;
		private Handler handler;

		// 权限
		// <uses-permission android:name="android.permission.INTERNET" />
		//
		// <uses-permission
		// android:name="android.permission.ACCESS_COARSE_LOCATION" />
		//
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		//
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		//
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		//
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		//
		// <uses-permission
		// android:name="android.permission.ACCESS_FINE_LOCATION" />
		//
		// <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.GET_TASKS" />

		// 其他
		// <activity
		// android:name="com.jd.integral.ShowJdActivity"
		// android:configChanges="keyboardHidden|orientation|navigation" />
		//
		// <meta-data
		// android:name="PUBLISHER_ID_INTEGRAL"
		// android:value="B66A673FDA9C60E914382ACF7B10DC1FA1179E80" />
		public void consumeScore() {
			final View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					// alertDialog.dismiss();
					int inputScore = Integer.valueOf(string);
					msg = Message.obtain();
					JdAdManager.spendScore(context, inputScore,
							new JdSpendScoreListener() {

								@Override
								public void jdConsumptionSuccess(int allScore,
										int reduceScore) {
									// TODO Auto-generated method stub
									msg.what = 1;
									msg.obj = "积分消费成功，当前剩余积分：" + allScore
											+ "　,成功消费：" + reduceScore;
									handler.sendMessage(msg);
								}

								@Override
								public void jdConsumptionLose(String arg0) {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = arg0;
									handler.sendMessage(msg);
								}
							});
				}
			});
		}

		private void initHandle() {
			handler = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功

						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}

		public void showOffWall() {
			JdAdManager.showAdOffers(context);
		}

		public void initSDK(String userid) {
			initHandle();
			JdAdManager.setUserID(context, userid);
			JdAdManager.setAddScoreListener(context, new JdAddScoreListener() {

				@Override
				public void jdAddScoreSucceed(int arg0, int arg1, String arg2,
						String arg3, String arg4) {
					// TODO Auto-generated method stub

				}

				@Override
				public void jdAddScoreFaild(String arg0, String arg1,
						String arg2) {
					// TODO Auto-generated method stub

				}
			});
		}

		public static JDAd getInstance(Context context) {
			return new JDAd(context);
		}

		private JDAd(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
			this.activity = (Activity) context;
		}
	}

	/**
	 * 
	 * @author DDstar 点入积分墙
	 */
	public static class DianRu {
		Context context;
		Activity activity;
		private Handler handle;

		// 权限
		// <!-- 访问网络权限 -->
		// <uses-permission android:name="android.permission.INTERNET" />
		// <!-- 获取网络信息状态，如当前的网络连接是否有效 -->
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <!-- 获取WIFI状态 -->
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <!-- 读取手机状态 -->
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <!-- 允许程序写入外部存储，如SD卡上读写文件 -->
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <!-- 获取位置信息 -->
		// <uses-permission
		// android:name="android.permission.ACCESS_COARSE_LOCATION" />
		// <uses-permission
		// android:name="android.permission.ACCESS_FINE_LOCATION" />
		// <!-- 允许程序获取当前或最近运行的应用 -->
		// <uses-permission android:name="android.permission.GET_TASKS" />

		// <meta-data
		// android:name="DR_APPKEY"
		// android:value="@string/app_key" />
		// <activity
		// android:name="com.mine.testmodel.DRActivity"
		// android:configChanges="keyboardHidden|orientation"
		// android:hardwareAccelerated="true"
		// android:theme="@android:style/Theme.Light.NoTitleBar" />
		// <service
		// android:name="com.yql.dr.sdk.ProcessService"
		// android:enabled="true"
		// android:exported="false" >
		// <intent-filter>
		// <!-- <action android:name="您的包名+.ProcessService" /> -->
		// <action android:name="com.yql.dr.demo.ProcessService" />
		// </intent-filter>
		// </service>

		private DianRu(Context context) {
			this.context = context;
			this.activity = (Activity) context;
		}

		public static DianRu getInstance(Context context) {
			return new DianRu(context);
		}

		public void consumeScore() {
			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = Message.obtain();
					int inputScore = Integer.valueOf(string);
					DRSdk.spendScore(inputScore, context,
							new DRScoreInterface() {

								@Override
								public void spendScoreCallback(boolean result) {
									// TODO Auto-generated method stub
									if (result) {
										msg.what = 1;
										msg.obj = "积分消费成功";
										// Toast.makeText(context, "积分消费成功",
										// Toast.LENGTH_LONG).show();
									} else {
										msg.what = 0;
										msg.obj = "积分不足";
										handle.sendMessage(msg);
									}
								}

								@Override
								public void scoreResultCallback(int score) {
									// TODO Auto-generated method stub
									msg.obj = msg.obj + "，当前积分：" + score;
									// Toast.makeText(context, "当前积分：" + score,
									// Toast.LENGTH_LONG).show();
									handle.sendMessage(msg);
								}
							});
				}
			});
		}

		public void showOffWall() {
			Intent intent = new Intent(context, DRActivity.class);
			// intent.putExtra(name, SDK显示类型);
			// DRSdk.DR_FREE 免费墙
			// DRSdk. DR_OFFER 积分墙
			intent.putExtra(DRSdk.DR_TYPE, DRSdk.DR_OFFER);
			context.startActivity(intent);
		}

		public void initSDK(String appuserid) {
			DRSdk.initialize(context, false, appuserid);
			initHandle();
		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 赢告
	 * 
	 * @author DDStar
	 *
	 */
	public static class WinGao {
		private Context context;
		private Activity activity;
		private Handler handle;

		// 权限
		// <!--连接网络权限，用于请求广告-->
		// <uses-permission android:name="android.permission.INTERNET" />
		// <!--读取网络信息权限，用于识别GPRS网络的接入点-->
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <!--读取手机基本信息权限，用于精确统计用户的机型等信息 -->
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <!--读写sd卡的权限，用于缓存广告所用到的图片，节省流量，并可获得更好的用户体验-->
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		//
		// <uses-permission
		// android:name="android.permission.ACCESS_WIFI_STATE"/>
		//
		// <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.GET_TASKS" />
		//
		// 界面 key配置
		// <activity
		// android:name="com.winad.android.offers.OffersActivity"
		// android:configChanges="keyboardHidden|orientation|navigation|screenSize"
		// />
		//
		// <meta-data android:value="BDF8D099DFE17D884140E5F18A2D85BFF49002DD"
		// android:name="PUBLISHER_ID_OFFERS" />
		private WinGao(Context context) {
			this.context = context;
			this.activity = (Activity) context;
		}

		public static WinGao getInstance(Context context) {

			return new WinGao(context);
		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功

						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}

		public void initSDK() {
			initHandle();
			com.winad.android.offers.AdManager.setAddScoreListener(context,
					new AddScoreListener() {

						@Override
						public void addScoreSucceed(int arg0, int arg1,
								String arg2) {
							// TODO Auto-generated method stub

						}

						@Override
						public void addScoreFaild(String arg0) {
							// TODO Auto-generated method stub

						}
					});
		}

		public void showWall() {
			com.winad.android.offers.AdManager.showAdOffers(context);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					final Message msg = Message.obtain();
					int inputScore = Integer.valueOf(string);
					com.winad.android.offers.AdManager.spendScore(context,
							inputScore, new SpendScoreListener() {

								@Override
								public void ConsumptionSuccess(int allScore,
										int reduceScore) {
									// TODO Auto-generated method stub
									// msg.what = 1;
									msg.obj = "积分消费成功，当前剩余积分：" + allScore
											+ "　,成功消费：" + reduceScore;
									// Toast.makeText(
									// context,
									// "积分消费成功，当前剩余积分：" + allScore
									// + "　,成功消费：" + reduceScore,
									// Toast.LENGTH_LONG).show();

								}

								@Override
								public void ConsumptionLose(String arg0) {
									// TODO Auto-generated method stub
									// msg.what = 0;
									msg.obj = "积分不足，消费失败";
									// Toast.makeText(context, "积分消费失败  " +
									// arg0,
									// Toast.LENGTH_LONG).show();

								}
							});
					handle.sendMessage(msg);
				}
			});

		}
	}

	/**
	 * 点乐
	 * 
	 * @author DDStar
	 *
	 */
	public static class Djoy {
		// 权限
		// <uses-permission
		// android:name="android.permission.SYSTEM_ALERT_WINDOW" />
		// <uses-permission android:name="android.permission.INTERNET"/>
		// <uses-permission android:name="android.permission.GET_TASKS"/>
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE"/>
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_WIFI_STATE"/>

		// 其他
		// <activity
		// android:name="com.kaixinduu.DevNativeActivity"
		// android:configChanges="keyboardHidden|orientation"
		// android:theme="@android:style/Theme.Translucent.NoTitleBar" />
		//
		// <service android:name="com.kaixinduu.DevNativeService" />
		// <meta-data android:name="com.dlnetwork.cid"
		// android:value="10010" />

		private Context context;
		private Activity activity;
		private Handler handle;

		private Djoy(Context context) {
			this.context = context;
			this.activity = (Activity) context;
		}

		public static Djoy getInstance(Context context) {
			return new Djoy(context);
		}

		public void initSDK(String appID) {
			initHandle();
			DevInit.initGoogleContext(activity, appID);
		}

		public void showOffWall() {
			DevInit.showOffers(context);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					DevInit.spendMoney(context, inputScore,
							new SpendMoneyListener() {

								@Override
								public void spendMoneySuccess(long arg0) {
									// TODO Auto-generated method stub
									msg.what = 1;
									msg.obj = "消费成功，剩余积分：" + arg0;
									// Toast.makeText(context, "" + arg0,
									Log.e("spendMoneySuccess", "arg0 = " + arg0);
									// Toast.LENGTH_LONG).show();
									handle.sendMessage(msg);
								}

								@Override
								public void spendMoneyFailed(String arg0) {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = arg0;
									Log.e("spendMoneyFailed", "arg0 = " + arg0);
									handle.sendMessage(msg);
								}
							});
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 贝多
	 * 
	 * @author DDStar
	 *
	 */
	public static class BeiDuo {

		private Context context;
		private Activity activity;
		private Handler handle;

		// 权限
		// <uses-permission android:name="android.permission.INTERNET"/>
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE"/>
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_WIFI_STATE"/>
		// <uses-permission android:name="android.permission.GET_TASKS"/>

		// 其他
		// <activity android:name="com.bb.dd.Browser"
		// android:configChanges="keyboardHidden|orientation|screenSize"/>
		// <activity android:name="com.bb.dd.MainActivity"
		// android:theme="@android:style/Theme.Translucent"
		// android:configChanges="keyboardHidden|orientation" />
		//
		// <service android:name="com.bb.dd.BDService" />
		// <meta-data android:name="beiduo_channel"
		// android:value="10000 " />

		private BeiDuo(Context context) {
			this.context = context;
			this.activity = (Activity) context;
		}

		public static BeiDuo getInstance(Context context) {
			return new BeiDuo(context);
		}

		public void initSDK(String APP_ID, String APP_Secret) {
			BeiduoPlatform.setAppId(context, APP_ID, APP_Secret);
			initHandle();
		}

		public void showOffWall() {
			BeiduoPlatform.showMoreApps(context);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					BeiduoPlatform.reduceMoney(inputScore,
							new IReduceListener() {

								@Override
								public void reduceSuccess(int arg0) {
									// TODO Auto-generated method stub
									msg.what = 1;
									msg.obj = "积分消费成功，当前积分：" + arg0;
									handle.sendMessage(msg);
								}

								@Override
								public void reduceFailed(int arg0) {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = arg0;
									handle.sendMessage(msg);
								}
							});
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 第七传媒
	 * 
	 * @author DDStar
	 *
	 */
	public static class DYKUM {

		// notic
		// 注意
		// MainActivity要继承com.dyk.Statisticsdk.BaseActivity包下的BaseActivity
		// 并复写其onCreate()、onResume()、onPause()方法

		// 权限
		// <uses-permission
		// android:name="android.permission.ACCESS_FINE_LOCATION" />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <uses-permission android:name="android.permission.GET_TASKS" />
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission android:name="android.permission.RESTART_PACKAGES"
		// />
		// <uses-permission
		// android:name="android.permission.SYSTEM_ALERT_WINDOW" />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission android:name="android.permission.WRITE_SETTINGS" />

		// 其他
		// <activity android:name="com.dyk.hfsdk.ui.ScoreWallActivity"
		// android:configChanges="orientation|screenSize" >
		// </activity>
		// <service android:name="com.dyk.hfsdk.util.DetectionService" >
		// <intent-filter android:priority="1000">
		// </service>
		// <activity
		// android:name="com.dyk.hfsdk.ui.ImgSubmit"
		// android:theme="@android:style/Theme.Dialog" >
		// </activity>
		// <meta-data
		// android:name="UMENG_APPKEY"
		// android:value="4df0356e431fe30eb8000077" >
		// </meta-data>
		// <meta-data
		// android:name="UMENG_CHANNEL"
		// android:value="m3001" >
		// </meta-data>

		private Context context;
		private Activity activity;
		private Handler handle;

		private DYKUM(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static DYKUM getInstance(Context context) {
			return new DYKUM(context);
		}

		public void showOffWall() {
			Access.getInstance().openWALL(context);
		}

		public void initSDK(String app_id, String app_channel, String player_id) {
			Access.getInstance().init(context, app_id, app_channel, player_id);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					boolean isSuccess = Access.getInstance().speedSCRORE(
							context, inputScore);
					if (isSuccess) {
						msg.what = 1;
						msg.obj = "积分消费成功,本次消费：" + inputScore;
					} else {
						msg.what = 0;
						msg.obj = "积分不足，消费失败";
					}
					handle.sendMessage(msg);
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 万普世纪
	 * 
	 * @author DDStar
	 *
	 */
	public static class WanPu {

		// 注意 如果设置android:targetSdkVersion，其值须设置为15 或15 以
		// 权限
		// <uses-permission android:name="android.permission.INTERNET"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_WIFI_STATE"/>
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
		// <uses-permission android:name="android.permission.GET_TASKS"/>

		private Context context;
		private Activity activity;
		private Handler handle;
		private AppConnect appConnect;

		private WanPu(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static WanPu getInstance(Context context) {
			return new WanPu(context);
		}

		public void showOffWall() {
			// TODO
			appConnect.showOffers(context);
		}

		public void initSDK(String APP_ID) {
			// TODO
			appConnect = AppConnect.getInstance(APP_ID, "baidu", activity);
			// AppConnect instance = AppConnect.getInstance(context);
		}

		public void destroyAd() {
			appConnect.close();
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					appConnect.spendPoints(inputScore,
							new UpdatePointsNotifier() {

								@Override
								public void getUpdatePointsFailed(String arg0) {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = arg0;
									handle.sendMessage(msg);
								}

								@Override
								public void getUpdatePoints(
										String currencyName, int pointTotal) {
									// TODO Auto-generated method stub
									msg.what = 1;
									msg.obj = "积分消费成功，当前剩余积分：" + pointTotal;
									handle.sendMessage(msg);
								}
							});
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 米迪
	 * 
	 * @author DDStar
	 *
	 */
	public static class MiDiAD {

		// 权限
		// <!-- 连接网络权限INTERNET (必须)-->
		// <uses-permission android:name="android.permission.INTERNET" />
		// <!-- 用于下载前检查网络状态 (必须)-->
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE"/>
		//
		// <!-- 往SDCard写入数据权限(必须) -->
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
		// <!-- 获取设备相关信息(必须) -->
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <!-- 获取mac地址 ，支持一些Pad设备不能获取imei的bug(必须) -->
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.GET_TASKS" />
		//
		// <activity
		// android:name="net.midi.wall.sdk.MyWallActivity" >
		// </activity>

		private Context context;
		private Activity activity;
		private Handler handle;

		private MiDiAD(Context context) {
			this.context = context;
			this.activity = (Activity) context;
		}

		public static MiDiAD getInstance(Context context) {
			return new MiDiAD(context);
		}

		public void showOffWall() {
			AdWall.showAppOffers(new IAdWallShowAppsNotifier() {

				@Override
				public void onShowApps() {
					// TODO Auto-generated method stub

				}

				@Override
				public void onDismissApps() {
					// TODO Auto-generated method stub

				}
			});
		}

		public void initSDK(String ProductId, String ProductPassword) {
			initHandle();
			AdWall.setUserActivity(context, "net.midi.wall.sdk.MyWallActivity");
			AdWall.init(context, ProductId, ProductPassword);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					AdWall.spendPoints(inputScore,
							new IAdWallSpendPointsNotifier() {

								@Override
								public void onSpendPoints(String currencyName,
										Integer pointTotal) {
									msg.what = 1;
									msg.obj = "积分消费成功，当前积分：" + pointTotal;
									handle.sendMessage(msg);
								}

								@Override
								public void onFailSpendPoints() {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = "积分不足，消费失败";
									handle.sendMessage(msg);
								}
							});
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 中亿广告
	 * 
	 * @author DDStar
	 *
	 */
	public static class ZhongYiAd {
		// 权限
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission android:name="android.permission.RESTART_PACKAGES"
		// />
		// <uses-permission
		// android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
		// <uses-permission android:name="android.permission.GET_TASKS"/>

		// 其他
		// <activity android:name="com.zy.phone.sdk.SDKActivity"
		// android:screenOrientation="portrait"
		// ></activity>
		// <!-- 广播注册 -->
		// <receiver android:name="com.zy.phone.service.BootReceiver"
		// >
		// <intent-filter android:priority="1000" >
		// <action android:name="android.intent.action.PACKAGE_ADDED" />
		// <action android:name="android.intent.action.PACKAGE_REMOVED"/>
		// <data android:scheme="package" />
		// </intent-filter>
		// </receiver>
		// <!--注册服务-->
		// <service android:name="com.zy.phone.service.ZYService" ></service>

		private Context context;
		private Activity activity;
		private Handler handle;

		private ZhongYiAd(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static ZhongYiAd getInstance(Context context) {
			return new ZhongYiAd(context);
		}

		public void showOffWall() {
			SDKInit.initAdList(context);
		}

		public void initSDK(String AdpCode, String userID) {
			initHandle();
			SDKInit.initAd(context, AdpCode, userID);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					SDKInit.minusIntegral(new Integral() {

						@Override
						public void retMinusIntegral(String retcode,
								String totalScore) {
							// 消费调用
							// retcode 0 消费成功
							// 1 查询失败
							// 2 积分不足，消费失败
							if ("0".equals(retcode)) {
								msg.what = 1;
								msg.obj = "消费成功,当前积分为：" + totalScore;
							} else {
								msg.what = 0;
								msg.obj = "积分不足，消费失败";
							}
							handle.sendMessage(msg);
						}

						@Override
						public void retCheckIntegral(String retcode,
								String totalScore) {
							// TODO Auto-generated method stub
							// 查询 调用
						}

						@Override
						public void retAddIntegral(String retcode,
								String totalScore) {
							// 增加 调用
						}
					}, "" + inputScore);
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 炅友
	 * 
	 * @author DDStar
	 *
	 */
	public static class JiongYou {
		// 权限
		// <!-- 加入权限 start -->
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission android:name="android.permission.GET_TASKS" />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission
		// android:name="android.permission.PACKAGE_USAGE_STATS"
		// tools:ignore="ProtectedPermissions" /><!--新增-->
		// <!-- 加入权限 end -->
		// 当配置权限 android.permission.PACKAGE_USAGE_STATS 时，还需要在 manifest
		// 标签中配置下面内容xmlns:tools="http://schemas.android.com/tools"

		// 其他
		// <!-- jarwall列表页 -->
		// <activity android:name="com.jy.func.JYOfferActivity"
		// android:configChanges="orientation|keyboardHidden"
		// android:launchMode="singleTask"/>
		// <!-- jarwall内容详情页 -->
		// <activity android:name="com.jy.func.JYOfferDetail"
		// android:configChanges="orientation|keyboardHidden"
		// android:launchMode="singleTask"/>
		// <service android:name="com.jy.func.JYService" />

		private Context context;
		private Activity activity;
		private Handler handle;
		private JYOfferWall jyOfferWall;

		private JiongYou(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static JiongYou getInstance(Context context) {
			return new JiongYou(context);
		}

		public void showOffWall() {
			jyOfferWall.showOfferWall(context);
		}

		public void initSDK(String uid, String appid, String appkey) {
			initHandle();
			jyOfferWall = JYOfferWall.getInstance(context);
			jyOfferWall.init(context, uid, appid, appkey);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					jyOfferWall.consumePoints(inputScore,
							new CheckPointListener() {

								@Override
								public void onError(int arg0) {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = "网络异常";
									handle.sendMessage(msg);
								}

								@Override
								public void onResponse(int status,
										float restPoint, float consumedPoint) {
									// TODO Auto-generated method stub
									// status:1:表示消费成功 2:表示余额不足
									// restPoint:用户的剩余积分数
									// consumedPoint:用户的已消费积分数
									switch (status) {
									case 1:
										msg.what = 1;
										msg.obj = "积分消费成功，当前积分：" + restPoint;

										break;
									case 2:

										msg.what = 0;
										msg.obj = "积分不足";
										break;

									default:
										break;
									}
									handle.sendMessage(msg);
								}
							});

				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 乐点广告
	 * 
	 * @author DDStar
	 *
	 */
	public static class LeDianAD {
		// 权限
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.SYSTEM_ALERT_WINDOW" />
		// <uses-permission android:name="android.permission.GET_TASKS" />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_COARSE_LOCATION" />
		// <uses-permission
		// android:name="android.permission.ACCESS_FINE_LOCATION" />
		// <uses-permission
		// android:name="android.permission.INTERACT_ACROSS_USERS_FULL"/>

		// 其他
		// <activity
		// android:name="com.lerdian.wall.MainActivity" >
		// </activity>
		// <activity
		// android:name="com.lerdian.wall.DetailActivity" />
		// <activity
		// android:name="com.lerdian.wall.point.DetailActivity" />
		// <activity
		// android:name="com.lerdian.search.SearchResult" />
		// <activity
		// android:name="com.lerdian.wall.point.FeedbackActivity"/>
		// <activity
		// android:name="com.lerdian.wall.point.StateActivity"/>
		// <activity
		// android:name="com.lerdian.wall.point.MainActivity" >
		// </activity>
		// <service android:name="com.lerdian.wall.point.DetailService">
		// <intent-filter>
		// <action android:name="com.lerdian.wall.point.DetailService"/>
		// </intent-filter>
		// </service>

		// 百度搜索
		// <activity
		// android:name="com.lerdian.search.SearchResult"
		// android:screenOrientation="portrait"
		// android:theme="@android:style/Theme.NoTitleBar" >
		// <intent-filter>
		// <action android:name="com.lerdian.search.SHORTCUT" />
		// <category android:name="android.intent.category.DEFAULT" />
		// </intent-filter>
		// </activity>

		// 密钥
		// <meta-data
		// android:name="LERDIAN_CHANNEL"
		// android:value="应用秘钥" />

		private Activity activity;
		private Handler handle;
		private Context context;
		private com.lerdian.startmanager.PointsManager mLeDianAd;

		private LeDianAD(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static LeDianAD getInstance(Context context) {
			return new LeDianAD(context);
		}

		public void showBaiduSearch() {
			SearchManger.openDetail(context);
		}

		public void showOffWall() {
			com.lerdian.startmanager.PointsManager.openPoints(activity);
		}

		public void initSDK() {
			// initHandle();
			mLeDianAd = com.lerdian.startmanager.PointsManager
					.getInstance(context);
			SearchManger.onCreate(context, false);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					mLeDianAd.consumptionPoints(context, inputScore, handle);
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					// String result = (String) msg.obj;
					switch (msg.what) {
					case EarnPointSun.REQUEST_INTEGRAL_SUCCESS:
						WallUser mWallAppUser = (WallUser) msg.obj;
						String points = "当前积分为"
								+ String.valueOf(mWallAppUser.getBalance());
						// 请求积分成功，使用textView将积分数量显示出来
						Toast.makeText(context, points, Toast.LENGTH_LONG)
								.show();
						// textView.setText(points);
						break;
					default:
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					}
				}
			};
		}
	}

	/**
	 * 百度广告
	 * 
	 * @author DDStar
	 *
	 */
	public static class BDAD {
		// 权限
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE"/>
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <!-- 用于记录uid -->
		// <uses-permission android:name="android.permission.WRITE_SETTINGS" />
		// <uses-permission android:name="android.permission.WAKE_LOCK" />

		// 界面 服务 key
		// <activity
		// android:name="com.baidu.ops.appunion.sdk.activity.AppListActivity"
		// android:configChanges="keyboardHidden|orientation|screenSize" />
		// <activity
		// android:name="com.baidu.ops.appunion.sdk.activity.WebActivity"
		// android:configChanges="keyboardHidden|orientation|screenSize" />
		// <service
		// android:name="com.baidu.ops.appunion.sdk.service.AppUnionService"
		// android:exported="false"
		// android:label="AppUnionService" />
		// <meta-data android:name="BDAPPUNIONSDK_APIKEY"
		// android:value="1003647a" />
		// <!-- BDAPPUNIONSDK end -->

		private Context context;
		private Activity activity;
		private Handler handle;
		private AppUnionSDK appUnionSDK;

		private BDAD(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			appUnionSDK = AppUnionSDK.getInstance(context);
			initHandle();
		}

		public static BDAD getInstance(Context context) {
			return new BDAD(context);
		}

		public void showOffWall() {
			appUnionSDK.showAppList();
		}

		public void destroySDK() {
			appUnionSDK.quitSdk();
		}

		public void initSDK() {
			appUnionSDK.initSdk();
		}

		private void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 果盟
	 * 
	 * @author DDStar
	 *
	 */
	public static class GuoMob {
		// 权限
		// <uses-permission
		// android:name="android.permission.READ_PHONE_STATE"></uses-permission>
		// <uses-permission
		// android:name="android.permission.ACCESS_WIFI_STATE"/>
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE"/>
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>
		// <uses-permission
		// android:name="android.permission.READ_EXTERNAL_STORAGE"/>
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
		// <uses-permission
		// android:name="android.permission.CHANGE_WIFI_STATE"/>
		// <uses-permission
		// android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
		// <uses-permission android:name="android.permission.GET_TASKS"/>

		// 其他
		// <activity android:name="cn.guomob.android.intwal.GuomobAlertActivity"
		// />
		// <activity android:name="cn.guomob.android.intwal.GuomobIntWaActivity"
		// />
		//
		// <service
		// android:name="cn.guomob.android.intwal.Service01"
		// android:exported="false" >
		// <intent-filter>
		// <action android:name="com.guomob.server01" />
		// </intent-filter>
		// </service>
		//
		// <receiver
		// android:name="cn.guomob.android.intwal.GuomobBrocastReciver"
		// android:exported="false" >
		// <intent-filter>
		// <action android:name="包名.guomob.action" />
		// </intent-filter>
		// </receiver>
		//
		// <meta-data
		// android:name="guomobwall"
		// android:value="应用key" />

		private Context context;
		private Activity activity;
		private Handler handle;

		class MyGBScoreCallBack implements GMScoreCallBack {

			@Override
			public void onSuccess(Context arg0, String arg1) {
				// TODO Auto-generated method stub

			}

		}

		private GuoMob(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static GuoMob getInstance(Context context) {
			return new GuoMob(context);
		}

		public void showOffWall() {
			OpenIntegralWall.getInstance().show("isYou");
		}

		public void initSDK() {
			OpenIntegralWall.initInterfaceType(activity,
					new MyGBScoreCallBack());
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					GMScoreManager.CutScore(context,
							new GMScoreManagerCallBack() {

								@Override
								public void onSuccess(String result) {
									// TODO Auto-generated method stub
									String[] scoreMsg = result.split("_");
									Log.e("result", "Main.call.result" + result);
									// 操作类型type
									int type = Integer.valueOf(scoreMsg[0]);
									Float score = Float.valueOf(scoreMsg[1]);
									// 如果是查询操作返回
									if (type == 1) {
										// 处理
									}
									// 如果是增加积分操作返回
									if (type == 2) {
									}
									// 如果是删除积分返回
									if (type == 3) {
										msg.what = 1;
										msg.obj = "积分消费成功，当前积分：" + score;
									}
									handle.sendMessage(msg);
								}

								@Override
								public void onFail(String arg0) {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = "";
									handle.sendMessage(msg);
								}
							}, inputScore, "");
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	// /**
	// * 趣米广告
	// *
	// * @author DDStar
	// *
	// */
	// public static class QuMiAD {
	// // 权限
	// // <uses-permission android:name="android.permission.INTERNET" />
	// // <uses-permission android:name="android.permission.READ_PHONE_STATE"
	// // />
	// // <uses-permission
	// // android:name="android.permission.ACCESS_NETWORK_STATE" />
	// // <uses-permission android:name="android.permission.GET_TASKS" />
	// // <uses-permission
	// // android:name="android.permission.SYSTEM_ALERT_WINDOW" />
	// // <uses-permission
	// // android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	// // <uses-permission
	// // android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
	// // <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
	// // />
	// // activity & service
	// // <activity
	// // android:name="com.newqm.pointwall.ShowActivity"
	// // android:configChanges="keyboardHidden|orientation" />
	// // <receiver android:name="com.newqm.pointwall.ApkReceiver" >
	// // <intent-filter>
	// // <action android:name="android.intent.action.PACKAGE_ADDED" />
	// // </intent-filter>
	// // <data android:scheme="package" />
	// // </receiver>
	// // <service android:name="com.newqm.pointwall.AppStartListenService">
	// // </service>
	//
	// private Context context;
	// private Activity activity;
	// private Handler handle;
	//
	// private QuMiAD(Context context) {
	// this.context = context;
	// this.activity = (Activity) context;
	// initHandle();
	// }
	//
	// public static QuMiAD getInstance(Context context) {
	// return new QuMiAD(context);
	// }
	//
	// public void showOffWall() {
	// QSdkManager.getsdkInstance().showOffers(new QEarnNotifier() {
	//
	// @Override
	// public void getPointsFailed(String arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void getPoints(int arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void earnedPoints(int arg0, int arg1) {
	// // TODO Auto-generated method stub
	//
	// }
	// });
	// }
	//
	// public void initSDK(String AppID, String appScreat) {
	// QSdkManager.init(context, AppID, appScreat);
	// }
	//
	// public void consumeScore() {
	//
	// View view = activity.getLayoutInflater().inflate(
	// R.layout.dialog_view, null);
	// final AlertDialog alertDialog = new AlertDialog.Builder(context)
	// .setView(view).create();
	// alertDialog.show();
	// final EditText etScore = (EditText) view
	// .findViewById(R.id.editText1);
	// Button BtCancle = (Button) view.findViewById(R.id.button1);
	// BtCancle.setOnClickListener(new OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// // TODO Auto-generated method stub
	// alertDialog.dismiss();
	// }
	// });
	// Button BtOK = (Button) view.findViewById(R.id.button2);
	// BtOK.setOnClickListener(new OnClickListener() {
	//
	// private Message msg;
	//
	// @Override
	// public void onClick(View v) {
	// String string = etScore.getText().toString();
	// Log.e("onClick", "string = " + string);
	// if (TextUtils.isEmpty(string)) {
	// Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
	// .show();
	// return;
	// }
	// msg = new Message();
	// int inputScore = Integer.valueOf(string);
	// // TODO
	// // 积分消费的代码
	// QSdkManager.getsdkInstance().spendPoints(
	// new QEarnNotifier() {
	//
	// @Override
	// public void getPointsFailed(String arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void getPoints(int pointTotal) {
	// // TODO Auto-generated method stub
	// msg.what = 1;
	// msg.obj = "积分消费成功，当前积分：" + pointTotal;
	// handle.sendMessage(msg);
	// }
	//
	// @Override
	// public void earnedPoints(int arg0, int arg1) {
	// // TODO Auto-generated method stub
	// msg.what = 0;
	// msg.obj = "";
	// handle.sendMessage(msg);
	// }
	// }, inputScore);
	// }
	// });
	//
	// }
	//
	// private void initHandle() {
	// handle = new Handler() {
	// @Override
	// public void handleMessage(Message msg) {
	// Log.e("handleMessage", "msg.what = " + msg.what);
	// String result = (String) msg.obj;
	// switch (msg.what) {
	// case 0:// 失败
	// Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
	// .show();
	// break;
	// case 1:// 成功
	// Toast.makeText(context, result, Toast.LENGTH_LONG)
	// .show();
	// break;
	//
	// default:
	// break;
	// }
	// }
	// };
	// }
	// }

	// /**
	// * 易积分
	// *
	// * @author DDStar
	// *
	// */
	// public static class YiJiFen {
	// // 权限
	// // <uses -permission android:name= "android.permissi on.INTERNET" />
	// // <uses -permission
	// // android:name= "android.permission.ACCESS_NETWORK_STATE" />
	// // <uses -permission
	// // android:name= "android.permission.READ_PHONE_STATE" />
	// // <uses -permission
	// // android:name= "android.permission.WRITE_EXTERNAL_STORAGE" />
	// // <uses -permission andr oid:name= "android.permission.GET_TASKS" />
	// // <uses -permission
	// // android:name= "android.permission.ACCESS_WIFI_STATE" />
	// // 界面
	// // <activity
	// // android:name="com.eadver.offer.sdk.view.WallActivity"
	// // android:configChanges="keyboardHidden|orientation"
	// // >
	// // </activity>
	// // <activity
	// // android:name="com.eadver.offer.sdk.view.DetailActivity"
	// // android:configChanges="keyboardHidden|orientation" />
	// // <activity
	// // android:name="com.eadver.offer.sdk.view.WebActivity"
	// // android:configChanges="keyboardHidden|orientation" />
	// // <service
	// // android:name=" com.eadver.offer.sdk.util.AdScoreService"
	// // android:exported=" false " >
	// // </service>
	// // <receiver
	// // android:name=" com.eadver.offer.sdk.view.EadverReceiver">
	// // <intent-filter>
	// // <action
	// // android:name="android.intent.action.PACKAGE_ADDED" />
	// // <action android:name="android.intent.action.PACKAGE_REMOVED" />
	// // <data android:scheme="package" />
	// // </intent-filter>
	// // </receiver >
	// private Context context;
	// private Activity activity;
	// private Handler handle;
	//
	// private YiJiFen(Context context) {
	// this.context = context;
	// this.activity = (Activity) context;
	// initHandle();
	// }
	//
	// public static YiJiFen getInstance(Context context) {
	// return new YiJiFen(context);
	// }
	//
	// public void showOffWall() {
	// ScoreWallSDK.getInstance(context).showScoreWall();
	// }
	//
	// public void initSDK(String id, String key, String DevID) {
	// YjfSDK.getInstance(context, new UpdateScordNotifier() {
	//
	// @Override
	// public void updateScoreSuccess(int arg0, int arg1, int arg2,
	// String arg3) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void updateScoreFailed(int arg0, int arg1, String arg2) {
	// // TODO Auto-generated method stub
	//
	// }
	// }).initInstance(id, key, DevID, "jifeng");
	// }
	//
	// public void consumeScore() {
	//
	// View view = activity.getLayoutInflater().inflate(
	// R.layout.dialog_view, null);
	// final AlertDialog alertDialog = new AlertDialog.Builder(context)
	// .setView(view).create();
	// alertDialog.show();
	// final EditText etScore = (EditText) view
	// .findViewById(R.id.editText1);
	// Button BtCancle = (Button) view.findViewById(R.id.button1);
	// BtCancle.setOnClickListener(new OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// // TODO Auto-generated method stub
	// alertDialog.dismiss();
	// }
	// });
	// Button BtOK = (Button) view.findViewById(R.id.button2);
	// BtOK.setOnClickListener(new OnClickListener() {
	//
	// private Message msg;
	//
	// @Override
	// public void onClick(View v) {
	// String string = etScore.getText().toString();
	// Log.e("onClick", "string = " + string);
	// if (TextUtils.isEmpty(string)) {
	// Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
	// .show();
	// return;
	// }
	// msg = new Message();
	// int inputScore = Integer.valueOf(string);
	// // TODO
	// // 积分消费的代码
	// ScoreWallSDK.getInstance(context).consumeScore(context,
	// new UpdateScordNotifier() {
	//
	// @Override
	// public void updateScoreSuccess(int type,
	// int current, int change, String unit) {
	// msg.what = 1;
	// msg.obj = "积分消费成功，当前积分：" + current;
	// handle.sendMessage(msg);
	// }
	//
	// @Override
	// public void updateScoreFailed(int type,
	// int code, String error) {
	// msg.what = 0;
	// msg.obj = "积分不足" + code;
	// handle.sendMessage(msg);
	// }
	// }, inputScore);
	// }
	// });
	//
	// }
	//
	// private void initHandle() {
	// handle = new Handler() {
	// @Override
	// public void handleMessage(Message msg) {
	// Log.e("handleMessage", "msg.what = " + msg.what);
	// String result = (String) msg.obj;
	// switch (msg.what) {
	// case 0:// 失败
	// Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
	// .show();
	// break;
	// case 1:// 成功
	// Toast.makeText(context, result, Toast.LENGTH_LONG)
	// .show();
	// break;
	//
	// default:
	// break;
	// }
	// }
	// };
	// }
	// }

	/**
	 * 有盟
	 * 
	 * @author DDStar
	 *
	 */
	public static class YouMengAD {

		// 权限
		// <uses-permission
		// android:name="android.permission.SYSTEM_ALERT_WINDOW" />
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE"
		// />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <uses-permission
		// android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
		// <uses-permission android:name="android.permission.RESTART_PACKAGES"
		// />
		// <uses-permission
		// android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
		// <uses-permission android:name="android.permission.RESTART_PACKAGES"
		// />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission
		// android:name="android.permission.READ_EXTERNAL_STORAGE" />
		// <!-- 以下是2.5.2 新版新添加的权限，必须添加-->
		// <uses-permission android:name="android.permission.GET_TASKS" />
		// <uses-permission
		// android:name="android.permission.PACKAGE_USAGE_STATS"
		// tools:ignore="ProtectedPermissions" />

		// 其他
		// <!-- 核心组件-->
		// <activity
		// android:name="com.ads8.AdActivity"
		// android:configChanges="keyboard|keyboardHidden|orientation"
		// android:excludeFromRecents="true"
		// android:theme="@android:style/Theme.Translucent.NoTitleBar" />
		// <!-- 积分墙列表-->
		// <activity
		// android:name="com.ads8.PointsActivity"
		// android:screenOrientation="portrait" />
		// <!-- 积分详细界面-->
		// <activity
		// android:name="com.ads8.AppDetailActivity"
		// android:screenOrientation="portrait" />
		// <!-- 广告服务-->
		// <service
		// android:name="com.ads8.service.AdService"
		// android:exported="false"
		// android:process="com.ads8.adService" />
		// <!-- app 监控服务-->
		// <service
		// android:name="com.ads8.service.AppMonitorService"
		// android:exported="false"
		// android:process="com.ads8.adService" />
		// <!-- 广告接收者-->
		// <receiver android:name="com.ads8.AdReceiver" >
		// <intent-filter android:priority="1000" >
		// <action android:name="android.intent.action.PACKAGE_REMOVED"
		// />
		// <action android:name="android.intent.action.PACKAGE_ADDED"
		// />
		// <action
		// android:name="android.intent.action.PACKAGE_REPLACED" />
		// <data android:scheme="package" />
		// </intent-filter>
		// </receiver>
		// <!-- app 监控接收者-->
		// <receiver android:name="com.ads8.AppMonitorReceiver" >
		// <intent-filter android:priority="1000" >
		// <action android:name="android.intent.action.BOOT_COMPLETED"
		// />
		// <action android:name="android.intent.action.USER_PRESENT" />
		// <action android:name="android.intent.action.SCREEN_OFF" />
		// </intent-filter>
		// </receiver>
		// <!-- 2015-10-14 2.5.2 版本新添加组件-->
		// <activity
		// android:name="com.ads8.UploadScreenshotActivity"/>

		private Context context;
		private Activity activity;
		private Handler handle;
		private com.ads8.util.PointsManager pointsManager;

		private YouMengAD(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static YouMengAD getInstance(Context context) {
			return new YouMengAD(context);
		}

		public void showOffWall() {
			pointsManager.showPointsWall();
		}

		public void initSDK(String WALL_ID) {
			pointsManager = com.ads8.util.PointsManager.getInsance(activity,
					WALL_ID);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					pointsManager.spendPoints(inputScore,
							new OnPointsSpendListener() {
								@Override
								public void onSpend(boolean isSuccess,
										int current) {
									msg.what = 1;
									msg.obj = "积分消费成功，当前积分：" + current;
									handle.sendMessage(msg);
									// MyLogger.jLog().d(
									// "onSpend = " + isSuccess + " " + count);
									// pointTV.setText("积分：" + count);
								}
							});
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 大头鸟
	 * 
	 * @author DDStar
	 *
	 */
	public static class BigHeadBirds {

		// 权限

		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission android:name="android.permission.GET_TASKS" />
		// <uses-permission
		// android:name="android.permission.PACKAGE_USAGE_STATS"
		// tools:ignore="ProtectedPermissions" />
		// 以下特殊位置
		// xmlns:tools="http://schemas.android.com/tools"

		// 其他

		// <service
		// android:name="com.datouniao.AdPublisher.service.AdsService"
		// android:exported="false" >
		// </service>
		//
		// <receiver
		// android:name="com.datouniao.AdPublisher.service.AppReceiver" >
		// <intent-filter>
		// <action android:name="android.intent.action.PACKAGE_ADDED" />
		// <action android:name="android.intent.action.PACKAGE_REMOVED" />
		// <action android:name="com.datouniao.AdPublisher.service.check" />
		//
		// <data android:scheme="package" />
		// </intent-filter>
		// </receiver>
		//
		// <activity
		// android:name="com.datouniao.AdPublisher.AdsOffersWebView"
		// android:configChanges="keyboardHidden|orientation" />
		// <!-- 渠道标识 -->
		// <meta-data
		// android:name="DTN_PLACE_ID"
		// android:value="DTN" />
		// Demo的key
		// config.setAppID("4b34ee15-ace1-4de5-bea9-f80f669e2514");
		// config.setSecretKey("hbwgepsosgwg");
		private Context context;
		private Activity activity;
		private Handler handle;
		private com.datouniao.AdPublisher.AppConnect appConnInstance;

		private BigHeadBirds(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static BigHeadBirds getInstance(Context context) {
			return new BigHeadBirds(context);
		}

		public void showOffWall() {
			appConnInstance.ShowAdsOffers();
		}

		public void initSDK(String AppKey, String AppScret) {
			AppConfig appConfig = new AppConfig();
			appConfig.setAppID(AppKey);
			appConfig.setSecretKey(AppScret);
			appConfig.setCtx(activity);
			appConnInstance = com.datouniao.AdPublisher.AppConnect
					.getInstance(appConfig);
		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
					appConnInstance.SpendAmount(inputScore,
							new SpendNotifier() {

								@Override
								public void GetSpendResponseFailed(String arg0) {
									// TODO Auto-generated method stub
									msg.what = 0;
									msg.obj = "";
									handle.sendMessage(msg);
								}

								@Override
								public void GetSpendResponse(
										String currency_name, float amount) {
									// TODO Auto-generated method stub
									msg.what = 1;
									msg.obj = "积分消费成功，当前积分：" + amount;
									handle.sendMessage(msg);
								}
							});
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 百度Banner广告横幅
	 * 
	 * @author DDStar
	 *
	 */
	public static class BaiDuBanner {

		// 权限
		// <uses-permission android:name="android.permission.INTERNET" />
		// <uses-permission android:name="android.permission.READ_PHONE_STATE"
		// />
		// <uses-permission
		// android:name="android.permission.ACCESS_NETWORK_STATE" />
		// <uses-permission
		// android:name="android.permission.ACCESS_COARSE_LOCATION" />
		// <uses-permission
		// android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
		// <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"
		// />
		// <!-- 以下为可选权限 -->
		// <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"
		// />
		// <uses-permission android:name="android.permission.RECORD_AUDIO" />
		// <uses-permission android:name="android.permission.VIBRATE" />
		// <uses-permission android:name="android.permission.CAMERA" />
		// <uses-permission
		// android:name="android.permission.ACCESS_FINE_LOCATION" />

		// <activity
		// android:name="com.baidu.mobads.AppActivity"
		// android:configChanges="keyboard|keyboardHidden|orientation" />
		//
		// <meta-data
		// android:name="BaiduMobAd_APP_ID"
		// android:value="e866cfb0" />
		// <activity
		// android:name="com.mdxx.fangjinguo.MDActivity"
		// android:excludeFromRecents="true"
		// android:exported="true" >
		// </activity>
		// <activity
		// android:name="com.mdxx.fangjinguo.MLActivity"
		// android:configChanges="orientation|screenSize|keyboardHidden"
		// android:excludeFromRecents="true"
		// android:exported="true" >
		// </activity>
		// <activity
		// android:name="com.mdxx.fangjinguo.MHActivity"
		// android:configChanges="orientation|screenSize|keyboardHidden"
		// android:excludeFromRecents="true"
		// android:exported="true" >
		// </activity>
		//
		// <service android:name="com.mdxx.fangjinguo.MOService" />

		private Context context;
		private Activity activity;
		private Handler handle;

		private BaiDuBanner(Context context, String adPlaceID) {
			this.context = context;
			this.activity = (Activity) context;
			// String mdId = "9b151acaf825b0d0abc1a792889b7117";
			// MPMan yoPan = MPMan.getInstance(context);
			// yoPan.setKey(context, mdId);
			// yoPan.setChannel(context, "fjg");
			// yoPan.getMessage(context, true);
			FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
					FrameLayout.LayoutParams.WRAP_CONTENT,
					FrameLayout.LayoutParams.WRAP_CONTENT);
			// 设置广告条的悬浮位置
			layoutParams.gravity = Gravity.BOTTOM;
			AdSettings.setKey(new String[] { "baidu", "中国" });
			// 创建广告view
			// String adPlaceID = "2015351";// 重要：请填上你的代码位ID,否则无法请求到广告
			AdView adView = new AdView(context, adPlaceID);
			// 设置监听器
			adView.setListener(new AdViewListener() {

				@Override
				public void onAdClick(JSONObject arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAdFailed(String arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAdReady(AdView arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAdShow(JSONObject arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAdSwitch() {
					// TODO Auto-generated method stub

				}
			});
			activity.addContentView(adView, layoutParams);
		}

		public static BaiDuBanner getInstance(Context context, String adPlaceID) {
			return new BaiDuBanner(context, adPlaceID);
		}

		public void showOffWall() {

		}

		public void initSDK() {

		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}

	/**
	 * 广告类模板
	 * 
	 * @author DDStar
	 *
	 */
	public static class CommonClass {

		private Context context;
		private Activity activity;
		private Handler handle;

		private CommonClass(Context context) {
			this.context = context;
			this.activity = (Activity) context;
			initHandle();
		}

		public static CommonClass getInstance(Context context) {
			return new CommonClass(context);
		}

		public void showOffWall() {

		}

		public void initSDK() {

		}

		public void consumeScore() {

			View view = activity.getLayoutInflater().inflate(
					R.layout.dialog_view, null);
			final AlertDialog alertDialog = new AlertDialog.Builder(context)
					.setView(view).create();
			alertDialog.show();
			final EditText etScore = (EditText) view
					.findViewById(R.id.editText1);
			Button BtCancle = (Button) view.findViewById(R.id.button1);
			BtCancle.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					alertDialog.dismiss();
				}
			});
			Button BtOK = (Button) view.findViewById(R.id.button2);
			BtOK.setOnClickListener(new OnClickListener() {

				private Message msg;

				@Override
				public void onClick(View v) {
					String string = etScore.getText().toString();
					Log.e("onClick", "string = " + string);
					if (TextUtils.isEmpty(string)) {
						Toast.makeText(context, "请输入积分", Toast.LENGTH_LONG)
								.show();
						return;
					}
					msg = new Message();
					int inputScore = Integer.valueOf(string);
					// TODO
					// 积分消费的代码
				}
			});

		}

		private void initHandle() {
			handle = new Handler() {
				@Override
				public void handleMessage(Message msg) {
					Log.e("handleMessage", "msg.what = " + msg.what);
					String result = (String) msg.obj;
					switch (msg.what) {
					case 0:// 失败
						Toast.makeText(context, "积分不足，消费失败", Toast.LENGTH_LONG)
								.show();
						break;
					case 1:// 成功
						Toast.makeText(context, result, Toast.LENGTH_LONG)
								.show();
						break;

					default:
						break;
					}
				}
			};
		}
	}
}
