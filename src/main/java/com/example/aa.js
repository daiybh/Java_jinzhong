var ssidIdx = 0; var changeWlanClick = 1; var WlanBasicPage = '2G'; var WlanAdvancePage = '2G'; var WlanSTAPIN = ''; var lanDevIndex = 1; var QoSCurInterface = ''; var DDNSProvider = ''; var ripIndex = ""; var previousPage = ""; var preAddDomain = ""; var editIndex = -1; var editDomain = ''; var curLanguage = "chinese"; var sptUserType = '1'; var sysUserType = '0'; var MenuName = ""; var StartIndex = 1; var Menu2Path = ""; var Menu3Path = ""; var menu2 = 0; var authMode = 0; var Passwordmode = 0; var changeMethod = 999; var manageFlag = 0; var UpgradeFlag = 0; var SaveDataFlag = 0; var RouteFlag = 0; var RouteContent = ""; var SaveLogContent = ""; var productName = 'HN8145V'; var menuArray = [{ name: "鐘舵€�", id: "Menu1_Status", deficon: "", clickicon: "", url: "" , subMenus: [ { name: "鐘舵€佹€昏", id: "Menu2_Sta_Overview", deficon: "", clickicon: "", url: "/html/ssmp/deviceinfo/e8cdeviceinfo.asp" , subMenus: [ { name: "鐘舵€佹€昏", id: "Menu3_SO_Overview", deficon: "", clickicon: "", url: "/html/ssmp/deviceinfo/e8cdeviceinfo.asp" }, { name: "閰嶇疆鍚戝", id: "Menu3_SO_Wizard", deficon: "", clickicon: "", url: "/html/ssmp/cfgguide/cfgwizard.asp" } ] }, { name: "缃戠粶渚т俊鎭�", id: "Menu2_Sta_WAN", deficon: "", clickicon: "", url: "/html/bbsp/waninfo/waninfoe8c.asp" , subMenus: [ { name: "IP杩炴帴淇℃伅", id: "Menu3_SW_IPinfo", deficon: "", clickicon: "", url: "/html/bbsp/waninfo/waninfoe8c.asp" }, { name: "閾捐矾杩炴帴淇℃伅", id: "Menu3_SW_Linkinfo", deficon: "", clickicon: "", url: "/html/amp/opticinfo/e8ceponlink_user.asp" } ] }, { name: "鐢ㄦ埛渚т俊鎭�", id: "Menu2_Sta_LAN", deficon: "", clickicon: "", url: "/html/amp/wlaninfo/e8cwlaninfo.asp" , subMenus: [ { name: "鏃犵嚎鎺ュ彛淇℃伅", id: "Menu3_SL_WLANinfo", deficon: "", clickicon: "", url: "/html/amp/wlaninfo/e8cwlaninfo.asp" }, { name: "瀹跺涵缃戠粶淇℃伅", id: "Menu3_HomeNetwork_info", deficon: "", clickicon: "", url: "/html/amp/wificoverinfo/wlancoverinfo.asp" }, { name: "浠ュお缃戞帴鍙ｄ俊鎭�", id: "Menu3_SL_Ethinfo", deficon: "", clickicon: "", url: "/html/amp/ethinfo/e8cethinfo.asp" }, { name: "USB鎺ュ彛淇℃伅", id: "Menu3_SL_USBinfo", deficon: "", clickicon: "", url: "/html/ssmp/usbconect/usbstatus.asp" } ] }, { name: "璇煶淇℃伅", id: "Menu2_Sta_Voice", deficon: "", clickicon: "", url: "/html/voip/cnstatus/cnregstatus.asp" , subMenus: [ { name: "璇煶淇℃伅", id: "Menu3_SV_Voiceinfo", deficon: "", clickicon: "", url: "/html/voip/cnstatus/cnregstatus.asp" } ] }, { name: "杩滅▼绠＄悊鐘舵€�", id: "Menu2_Sta_Management", deficon: "", clickicon: "", url: "/html/ssmp/RomteInfo/e8cRemoteInfo.asp" , subMenus: [ { name: "浜や簰寤虹珛", id: "Menu3_SM_Interactive", deficon: "", clickicon: "", url: "/html/ssmp/RomteInfo/e8cRemoteInfo.asp" }, { name: "涓氬姟閰嶇疆涓嬪彂鐘舵€�", id: "Menu3_SM_Setupstatus", deficon: "", clickicon: "", url: "/html/ssmp/RomteInfo/remoteopt.asp" } ] } ] }, { name: "缃戠粶", id: "Menu1_Network", deficon: "", clickicon: "", url: "" , subMenus: [ { name: "鐢ㄦ埛渚х鐞�", id: "Menu2_Net_LAN", deficon: "", clickicon: "", url: "/html/bbsp/dhcp/dhcpe8c.asp" , subMenus: [ { name: "IPv4閰嶇疆", id: "Menu3_ND_IPv4", deficon: "", clickicon: "", url: "/html/bbsp/dhcp/dhcpe8c.asp" }, { name: "IPv6閰嶇疆", id: "Menu3_ND_IPv6", deficon: "", clickicon: "", url: "/html/bbsp/lanaddress/lanaddresse8c.asp" }, { name: "瀹跺涵缃戠粶鍛藉悕", id: "Menu3_ND_Named", deficon: "", clickicon: "", url: "/html/bbsp/userdevinfo/homenetname.asp" } ] }, { name: "WLAN璁剧疆", id: "Menu2_Net_WLAN", deficon: "", clickicon: "", url: "/html/amp/wlanbasic/e8cWlanBasic.asp?2G" , subMenus: [ { name: "2.4G鏃犵嚎鍩烘湰璁剧疆", id: "Menu3_NW_Basic_2G", deficon: "", clickicon: "", url: "/html/amp/wlanbasic/e8cWlanBasic.asp?2G" }, { name: "2.4G鏃犵嚎楂樼骇璁剧疆", id: "Menu3_NW_Advanced_2G", deficon: "", clickicon: "", url: "/html/amp/wlanadv/e8cWlanAdvance.asp?2G" }, { name: "5G鏃犵嚎鍩烘湰璁剧疆", id: "Menu3_NW_Basic_5G", deficon: "", clickicon: "", url: "/html/amp/wlanbasic/e8cWlanBasic.asp?5G" }, { name: "5G鏃犵嚎楂樼骇璁剧疆", id: "Menu3_NW_Advanced_5G", deficon: "", clickicon: "", url: "/html/amp/wlanadv/e8cWlanAdvance.asp?5G" }, { name: "鏅鸿兘瑕嗙洊缃戠粶绠＄悊", id: "Menu3_Wifi_Cover_Cfg", deficon: "", clickicon: "", url: "/html/amp/wificovercfg/wifiCover.asp" } ] }, { name: "杩滅▼绠＄悊", id: "Menu2_Net_Management", deficon: "", clickicon: "", url: "/html/ssmp/loid/loid.asp" , subMenus: [ { name: "瀹藉甫璇嗗埆鐮侊紙LOID锛夎璇�", id: "Menu3_NM_Loid", deficon: "", clickicon: "", url: "/html/ssmp/loid/loid.asp" } ] }, { name: "璺敱閰嶇疆", id: "Menu2_Net_Route", deficon: "", clickicon: "", url: "/html/bbsp/routeinfo/routeinfochina.asp" , subMenus: [ { name: "璺敱琛�", id: "", deficon: "", clickicon: "", url: "/html/bbsp/routeinfo/routeinfochina.asp" } ] } ] }, { name: "瀹夊叏", id: "Menu1_Secure", deficon: "", clickicon: "", url: "" , subMenus: [ { name: "骞垮煙缃戣闂缃�", id: "Menu2_Secu_WAN", deficon: "", clickicon: "", url: "/html/bbsp/urlfiltersetting/urlfiltersettinge8c.asp" , subMenus: [ { name: "骞垮煙缃戣闂缃�", id: "Menu3_SeW_WAN", deficon: "", clickicon: "", url: "/html/bbsp/urlfiltersetting/urlfiltersettinge8c.asp" }, { name: "ONT璁块棶鎺у埗閰嶇疆", id: "", deficon: "", clickicon: "", url: "/html/bbsp/acl/acl.asp" } ] }, { name: "闃茬伀澧�", id: "Menu2_Secu_Firewall", deficon: "", clickicon: "", url: "/html/bbsp/firewalllevel/firewalle8c.asp" , subMenus: [ { name: "IPv4闃茬伀澧�", id: "Menu3_SeF_Firewall", deficon: "", clickicon: "", url: "/html/bbsp/firewalllevel/firewalle8c.asp" }, { name: "IPv6闃茬伀澧�", id: "Menu3_SeF_IPV6Firewall", deficon: "", clickicon: "", url: "/html/bbsp/ipv6firewall/firewall.asp" } ] }, { name: "MAC杩囨护", id: "Menu2_Secu_MAC", deficon: "", clickicon: "", url: "/html/bbsp/macfilter/macfiltere8c.asp" , subMenus: [ { name: "MAC杩囨护", id: "Menu3_SeM_MAC", deficon: "", clickicon: "", url: "/html/bbsp/macfilter/macfiltere8c.asp" } ] } ] }, { name: "搴旂敤", id: "Menu1_Application", deficon: "", clickicon: "", url: "" , subMenus: [ { name: "鏃ュ父搴旂敤", id: "Menu2_App_Application", deficon: "", clickicon: "", url: "/html/ssmp/usbftp/e8cusbhost.asp" , subMenus: [ { name: "杩滅▼涓嬭浇", id: "", deficon: "", clickicon: "", url: "/html/ssmp/usbftp/e8cusbhost.asp" }, { name: "瀹跺涵鍏变韩", id: "", deficon: "", clickicon: "", url: "/html/ssmp/samba/e8csamba.asp" }, { name: "濯掍綋鍏变韩", id: "", deficon: "", clickicon: "", url: "/html/ssmp/dlna/e8cdlna.asp" } ] } ] }, { name: "绠＄悊", id: "Menu1_Managemen", deficon: "", clickicon: "", url: "/html/ssmp/maintain/smartdiagnose.asp" , subMenus: [ { name: "鐢ㄦ埛绠＄悊", id: "Menu2_Mng_User", deficon: "", clickicon: "", url: "/html/ssmp/accoutcfg/e8caccount.asp" , subMenus: [ { name: "鐢ㄦ埛绠＄悊", id: "Menu3_MU_User", deficon: "", clickicon: "", url: "/html/ssmp/accoutcfg/e8caccount.asp" } ] }, { name: "璁惧绠＄悊", id: "Menu2_Mng_Device", deficon: "", clickicon: "", url: "/html/ssmp/devmanage/e8cdevicemanormal.asp" , subMenus: [ { name: "璁惧绠＄悊", id: "Menu2_Mng_Device", deficon: "", clickicon: "", url: "/html/ssmp/devmanage/e8cdevicemanormal.asp" } ] }, { name: "涓€閿瘖鏂�", id: "", deficon: "", clickicon: "", url: "/html/ssmp/maintain/smartdiagnose.asp" , subMenus: [ { name: "涓€閿瘖鏂�", id: "", deficon: "", clickicon: "", url: "/html/ssmp/maintain/smartdiagnose.asp" } ] } ] }, { name: "甯姪", id: "Menu1_Help", deficon: "", clickicon: "", url: "" , subMenus: [ { name: "鐘舵€佸府鍔�", id: "Menu2_Help_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/StatusDeviceHelpwithCfgguide.asp" , subMenus: [ { name: "鐘舵€佹€昏甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/StatusDeviceHelpwithCfgguide.asp" }, { name: "缃戠粶渚т俊鎭府鍔�", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/bbsp/help/StatusNetHelp.asp" }, { name: "鐢ㄦ埛渚т俊鎭府鍔�", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/StatusUserHelp.asp" }, { name: "璇煶淇℃伅甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/voip/help/StatusVoiceHelp.asp" }, { name: "杩滅▼绠＄悊鐘舵€佸府鍔�", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/StatusRouteHelp.asp" } ] }, { name: "缃戠粶甯姪", id: "Menu2_Help_Help", deficon: "", clickicon: "", url: "/html/bbsp/help/NetDHCPHelp.asp" , subMenus: [ { name: "鐢ㄦ埛渚х鐞嗗府鍔�", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/bbsp/help/NetDHCPHelp.asp" }, { name: "WLAN閰嶇疆甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/amp/help/NetWlanSetHelp.asp" }, { name: "杩滅▼绠＄悊甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/NetRemoteSetHelp.asp" } ] }, { name: "瀹夊叏甯姪", id: "Menu2_Help_Help", deficon: "", clickicon: "", url: "/html/bbsp/help/SafeWanHelp.asp" , subMenus: [ { name: "骞垮煙缃戣闂缃府鍔�", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/bbsp/help/SafeWanHelp.asp" }, { name: "闃茬伀澧欏府鍔�", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/bbsp/help/SafeWallHelp.asp" }, { name: "MAC杩囨护甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/bbsp/help/SafeMacHelp.asp" } ] }, { name: "搴旂敤甯姪", id: "Menu2_Help_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/UseUSBHelp.asp" , subMenus: [ { name: "鏃ュ父搴旂敤甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/UseUSBHelp.asp" } ] }, { name: "绠＄悊甯姪", id: "Menu2_Help_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/ManageUserHelp.asp" , subMenus: [ { name: "鐢ㄦ埛绠＄悊甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/ManageUserHelp.asp" }, { name: "璁惧绠＄悊甯姪", id: "Menu3_HH_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/ManageRootDeviceHelp.asp" }, { name: "寮€婧愯蒋浠朵娇鐢ㄥ０鏄�", id: "", deficon: "", clickicon: "", url: "/html/ssmp/softnotice/opensfnotice.asp" } ] }, { name: "璇婃柇甯姪", id: "Menu2_Help_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/OneClickDiagHelp.asp" , subMenus: [ { name: "涓€閿瘖鏂府鍔�", id: "Menu3_Diagnosis_Help", deficon: "", clickicon: "", url: "/html/ssmp/help/OneClickDiagHelp.asp" } ] } ] } ];; var IsLAN = '0'; var MngtGdct = '0'; document.title = productName; function stManageFlag(ManageFlag) { manageFlag = ManageFlag; } function GetIdByUrl(Type, BaseUrl) { var NewId = Type+"_"; var MarkEnd=""; try{ var lastindex = BaseUrl.lastIndexOf('/'); if( lastindex > -1 ) { NewId += BaseUrl.substring(lastindex+1, BaseUrl.length); } else { NewId += BaseUrl; } if(NewId.indexOf("?") > -1) { MarkEnd = NewId.split("?")[1]; } NewId = NewId.split(".")[0]+MarkEnd; }catch(e){ NewId += Math.round(Math.random() * 10000); } return NewId; } function GetNameById(Type, BaseId) { var NewId = Type+"_"; var MarkEnd=""; try{ var lastindex = BaseId.lastIndexOf('_'); if( lastindex > -1 ) { NewId += BaseId.substring(lastindex+1, BaseId.length); } else { NewId += BaseId; } }catch(e){ NewId += BaseId; } return NewId; } var Frame = { menuItems : [], mainMenuCounter : 0, subMenuCounter : 0, sub2MenuCounter : 0, $mainMenu : null, $content : null, init : function() { this.initData(); this.initElement(); }, initData : function() { var frame = this; this.mainMenuCounter = 0; this.subMenuCounter = 0; this.$mainMenu = $("#content_mainitems table tr"); this.$content = $("#frameContent"); this.$content.load(function() { frame.setContentHeight(); }); this.menuItems = eval(menuArray); }, initElement : function() { $("#productTypeName").text(productName); this.setLogoutElement(); this.addMenuItems(this.$mainMenu, this.menuItems, "main"); this.$mainMenu.find('.main_item .item_link a').eq(0).click(); }, addMenuItems : function(element, menus, type) { var frame = this; switch (type) { case 'main' : this.mainMenuCounter = 0; for (var i = 0, len = menus.length; i < len; i++) { var maindivname = GetNameById("maindiv", menus[i].id); var mainRelname = GetNameById("mainrel", menus[i].id); var mainTdname = GetNameById("maintd", menus[i].id); element.append('' + '
' + '
' + '' + menus[i].name + '' + '
' + ''); } var tdEls = element.children('td'); tdEls.find('.item_link a').mouseover(function() { $(this).css({ 'color' : '#F0422A', 'text-decoration' : 'underline' }); }).mouseout(function() { $(this).css({ 'color' : '#000000', 'text-decoration' : 'none' }); }).click(function() { if (!tdEls.eq(this.rev).is(".hover")) { $('#LocationDisplay').text($(this).text()); tdEls.eq(frame.mainMenuCounter).removeClass("hover"); tdEls.eq(this.rev).addClass("hover"); frame.mainMenuCounter = this.rev; frame.addMenuItems($('#content_seconditems table tr td'), menus[this.rev].subMenus, "sub2"); MenuName = menus[this.rev].name; $('#content_seconditems table tr td .sub2itemspan a').eq(0).click(); } }); break; case 'sub2' : frame.subMenuCounter = 0; var str = '|'; for (var i = 0, len = menus.length; i < len; i++) { var subspanname = GetIdByUrl("subspan", menus[i].url); var subRelname = GetIdByUrl("subrel", menus[i].url); str += '' + menus[i].name + '|'; } element.html(str); element.find('.sub2itemspan a').mouseover(function() { $(this).css({ 'text-decoration' : 'underline' }); }).mouseout(function() { $(this).css({ 'text-decoration' : 'none' }); }).click(function() { var sub2Els = element.children(".sub2itemspan"); sub2Els.eq(frame.subMenuCounter).removeClass("hover"); sub2Els.eq(this.rev).addClass("hover"); frame.addMenuItems($('#nav'), menus[this.rev].subMenus, "sub3"); frame.subMenuCounter = this.rev; $('#nav .sub3item a').eq(0).click(); }); break; case 'sub3' : element.empty(); frame.sub2MenuCounter = 0; for (var i = 0, len = menus.length; i < len; i++) { var subPname = GetIdByUrl("subspan", menus[i].url); var sub3Relname = GetIdByUrl("subrel", menus[i].url); if(1 == MngtGdct){ if( 1 == IsLAN && "Menu3_NM_Loid" == menus[i].id){ menus[i].name = "瀹藉甫璇嗗埆鐮侊紙LOID锛夎璇�"; } } element.append('
' + menus[i].name + '

'); } element.find('.sub3item a').mouseover(function() { $(this).css({ 'text-decoration' : 'underline' }); }).mouseout(function() { $(this).css({ 'text-decoration' : 'none' }); }).click(function(event,userPara) { var sub3Els = element.children(".sub3item"); sub3Els.eq(frame.sub2MenuCounter).removeClass("hover"); sub3Els.eq(this.rev).addClass("hover"); frame.sub2MenuCounter = this.rev; if('undefined' != typeof(userPara)){ return; } frame.setContentPath(this.rel); }); break; } }, setContentPath : function(url) { var msg; if (UpgradeFlag == 1) { if (curLanguage == 'chinese') { msg = '鎻愰啋:绯荤粺姝ｅ湪鍗囩骇锛岀寮€鏈〉闈細瀵艰嚧鍗囩骇澶辫触銆傚己鐑堝缓璁偍鐐瑰嚮\"鍙栨秷\"锛屽仠鐣欏湪鏈〉闈紝鐩村埌鍗囩骇鎴愬姛銆�'; } else if (curLanguage == 'english') { msg = 'Note: Upgrade will be interrupted and the device might not boot successfully next time if you switch to another page. It is strongly recommended to press cancel and remain on this page until the upgrade is complete.'; } if (confirm(msg)) { UpgradeFlag = 0; this.$content.attr("src", url); } } else { this.$content.attr("src", url); } }, setContentHeight : function() { setInterval(function() { try { var height = 0; if (window.ActiveXObject) { height = document.getElementById("frameContent").contentWindow.document.body.scrollHeight; } else if (window.XMLHttpRequest) { height = document.getElementById("frameContent").contentWindow.document.body.offsetHeight; } height = Math.max(height, 490); $("#center").height(height); $("#center div").height(height); $("#frameContent").height(height); } catch (e) { } }, 200); }, setLogoutElement : function() { var frame = this; if ( ('CMCC' == CfgMode.toUpperCase())||('JSCMCC' == CfgMode.toUpperCase())) { $("#header_logo #buttonLogout").mouseover(function() { $(this).css({ 'color' : '#FFFFFF', 'text-decoration' : 'underline' }); }).mouseout(function() { $(this).css({ 'color' : '#FFFFFF', 'text-decoration' : 'none' }); }).click(function() { frame.clickLogout(); }); } else{ $("#header_logo #buttonLogout").mouseover(function() { $(this).css({ 'color' : '#F0422A', 'text-decoration' : 'underline' }); }).mouseout(function() { $(this).css({ 'color' : '#0436A5', 'text-decoration' : 'none' }); }).click(function() { frame.clickLogout(); }); } }, clickLogout : function() { var sUserAgent = navigator.userAgent var isIELarge11 = (sUserAgent.indexOf("Trident") > -1 && sUserAgent.indexOf("rv") > -1); if (isIELarge11) { $.post('/logout.cgi?&RequestFile=/html/logout.html'); window.location = "/html/logout.html"; } else { var Form = new webSubmitForm(); Form.setAction('/logout.cgi?/RequestFile=html/logout.html'); Form.submit(); } }, show : function() { var frame = this; $(document).ready(function() { frame.init(); }); }, changeMenuShow:function(mainMenuId,secMenuId,thirdMenuId){ var firstMenuIdx = 0; var secMenuIdx = 0; var thirdMenuIdx = 0; this.$mainMenu.find('.main_item').each(function(i,menu){ if(mainMenuId == menu.id){ firstMenuIdx = i; } }); this.$mainMenu.find('.main_item .item_link a').eq(firstMenuIdx).click(); $('#content_seconditems table tr td .sub2itemspan').each(function(i,menu){ if(secMenuId == menu.id){ secMenuIdx = i; } }); $('#content_seconditems table tr td .sub2itemspan a').eq(secMenuIdx).click(); $('#nav .sub3item').each(function(i,menu){ if(thirdMenuId == menu.id){ thirdMenuIdx = i; } }); $('#nav .sub3item a').eq(thirdMenuIdx).trigger("click",[false]); } }; Frame.show();