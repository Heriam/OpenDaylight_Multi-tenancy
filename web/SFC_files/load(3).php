var mediaWikiLoadStart=(new Date()).getTime();function isCompatible(ua){if(ua===undefined){ua=navigator.userAgent;}return!((ua.indexOf('MSIE')!==-1&&parseFloat(ua.split('MSIE')[1])<6)||(ua.indexOf('Firefox/')!==-1&&parseFloat(ua.split('Firefox/')[1])<3)||ua.match(/BlackBerry[^\/]*\/[1-5]\./)||ua.match(/webOS\/1\.[0-4]/)||ua.match(/PlayStation/i)||ua.match(/SymbianOS|Series60/)||ua.match(/NetFront/)||ua.match(/Opera Mini/)||ua.match(/S40OviBrowser/)||(ua.match(/Glass/)&&ua.match(/Android/)));}var startUp=function(){mw.config=new mw.Map(true);mw.loader.addSource({"local":{"loadScript":"/load.php","apiScript":"/api.php"}});mw.loader.register([["site","1456197848",[],"site"],["noscript","1456197848",[],"noscript"],["startup","1456257924",[],"startup"],["filepage","1456197848"],["user.groups","1456197848",[],"user"],["user","1456197848",[],"user"],["user.cssprefs","1456172624",["mediawiki.user"],"private"],["user.options","1456172624",[],"private"],["user.tokens","1456172624",[],"private"],
["mediawiki.language.data","1456197848",["mediawiki.language.init"]],["mediawiki.skinning.elements","1456197848"],["mediawiki.skinning.content","1456197848"],["mediawiki.skinning.interface","1456197848"],["skins.cologneblue","1456197848"],["skins.modern","1456197848"],["skins.vector.styles","1456197848"],["skins.monobook.styles","1456197848"],["skins.vector.js","1456197848",["jquery.throttle-debounce"]],["skins.vector.collapsibleNav","1456240105",["jquery.client","jquery.cookie","jquery.tabIndex"]],["jquery","1456197848"],["jquery.appear","1456197848"],["jquery.arrowSteps","1456197848"],["jquery.async","1456197848"],["jquery.autoEllipsis","1456197848",["jquery.highlightText"]],["jquery.badge","1456197848",["mediawiki.language"]],["jquery.byteLength","1456197848"],["jquery.byteLimit","1456197848",["jquery.byteLength"]],["jquery.checkboxShiftClick","1456197848"],["jquery.chosen","1456197848"],["jquery.client","1456197848"],["jquery.color","1456197848",["jquery.colorUtil"]],[
"jquery.colorUtil","1456197848"],["jquery.cookie","1456197848"],["jquery.delayedBind","1456197848"],["jquery.expandableField","1456197848"],["jquery.farbtastic","1456197848",["jquery.colorUtil"]],["jquery.footHovzer","1456197848"],["jquery.form","1456197848"],["jquery.fullscreen","1456197848"],["jquery.getAttrs","1456197848"],["jquery.hidpi","1456197848"],["jquery.highlightText","1456197848",["jquery.mwExtension"]],["jquery.hoverIntent","1456197848"],["jquery.json","1456197848"],["jquery.localize","1456197848"],["jquery.makeCollapsible","1456197848"],["jquery.mockjax","1456197848"],["jquery.mw-jump","1456197848"],["jquery.mwExtension","1456197848"],["jquery.placeholder","1456197848"],["jquery.qunit","1456197848"],["jquery.qunit.completenessTest","1456197848",["jquery.qunit"]],["jquery.spinner","1456197848"],["jquery.jStorage","1456197848",["jquery.json"]],["jquery.suggestions","1456197848",["jquery.highlightText"]],["jquery.tabIndex","1456197848"],["jquery.tablesorter","1456197848",[
"jquery.mwExtension","mediawiki.language.months"]],["jquery.textSelection","1456197848",["jquery.client"]],["jquery.throttle-debounce","1456197848"],["jquery.validate","1456197848"],["jquery.xmldom","1456197848"],["jquery.tipsy","1456197848"],["jquery.ui.core","1456197848",[],"jquery.ui"],["jquery.ui.widget","1456197848",[],"jquery.ui"],["jquery.ui.mouse","1456197848",["jquery.ui.widget"],"jquery.ui"],["jquery.ui.position","1456197848",[],"jquery.ui"],["jquery.ui.draggable","1456197848",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.droppable","1456197848",["jquery.ui.core","jquery.ui.draggable","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.resizable","1456197848",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.selectable","1456197848",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.sortable","1456197848",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],
"jquery.ui"],["jquery.ui.accordion","1456197848",["jquery.ui.core","jquery.ui.widget"],"jquery.ui"],["jquery.ui.autocomplete","1456197848",["jquery.ui.core","jquery.ui.position","jquery.ui.widget"],"jquery.ui"],["jquery.ui.button","1456197848",["jquery.ui.core","jquery.ui.widget"],"jquery.ui"],["jquery.ui.datepicker","1456197848",["jquery.ui.core"],"jquery.ui"],["jquery.ui.dialog","1456197848",["jquery.ui.button","jquery.ui.core","jquery.ui.draggable","jquery.ui.mouse","jquery.ui.position","jquery.ui.resizable","jquery.ui.widget"],"jquery.ui"],["jquery.ui.progressbar","1456197848",["jquery.ui.core","jquery.ui.widget"],"jquery.ui"],["jquery.ui.slider","1456197848",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.tabs","1456197848",["jquery.ui.core","jquery.ui.widget"],"jquery.ui"],["jquery.effects.core","1456197848",[],"jquery.ui"],["jquery.effects.blind","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.bounce","1456197848",[
"jquery.effects.core"],"jquery.ui"],["jquery.effects.clip","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.drop","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.explode","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.fade","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.fold","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.highlight","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.pulsate","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.scale","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.shake","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.slide","1456197848",["jquery.effects.core"],"jquery.ui"],["jquery.effects.transfer","1456197848",["jquery.effects.core"],"jquery.ui"],["moment","1456197848"],["mediawiki","1456197848"],["mediawiki.api","1456197848",["mediawiki.util"]],["mediawiki.api.category","1456197848",[
"mediawiki.Title","mediawiki.api"]],["mediawiki.api.edit","1456197848",["mediawiki.Title","mediawiki.api","user.tokens"]],["mediawiki.api.login","1456197848",["mediawiki.api"]],["mediawiki.api.parse","1456197848",["mediawiki.api"]],["mediawiki.api.watch","1456197848",["mediawiki.api","user.tokens"]],["mediawiki.debug","1456197848",["jquery.footHovzer","jquery.tipsy"]],["mediawiki.debug.init","1456197848",["mediawiki.debug"]],["mediawiki.feedback","1456197848",["jquery.ui.dialog","mediawiki.Title","mediawiki.api.edit","mediawiki.jqueryMsg"]],["mediawiki.hidpi","1456197848",["jquery.hidpi"]],["mediawiki.hlist","1456197848",["jquery.client"]],["mediawiki.htmlform","1456207224"],["mediawiki.icon","1456197848"],["mediawiki.inspect","1456197848",["jquery.byteLength","jquery.json"]],["mediawiki.notification","1456197848",["mediawiki.page.startup"]],["mediawiki.notify","1456197848"],["mediawiki.searchSuggest","1456197848",["jquery.client","jquery.placeholder","jquery.suggestions",
"mediawiki.api"]],["mediawiki.Title","1456197848",["jquery.byteLength","mediawiki.util"]],["mediawiki.toc","1456197848",["jquery.cookie"]],["mediawiki.Uri","1456197848"],["mediawiki.user","1456197848",["jquery.cookie","mediawiki.api","user.options","user.tokens"]],["mediawiki.util","1456197848",["jquery.client","jquery.mwExtension","mediawiki.notify","mediawiki.toc"]],["mediawiki.action.edit","1456197848",["jquery.byteLimit","jquery.textSelection","mediawiki.action.edit.styles"]],["mediawiki.action.edit.styles","1456197848"],["mediawiki.action.edit.collapsibleFooter","1456197848",["jquery.cookie","jquery.makeCollapsible","mediawiki.icon"]],["mediawiki.action.edit.preview","1456197848",["jquery.form","jquery.spinner","mediawiki.action.history.diff"]],["mediawiki.action.history","1456197848",[],"mediawiki.action.history"],["mediawiki.action.history.diff","1456197848",[],"mediawiki.action.history"],["mediawiki.action.view.dblClickEdit","1456197848",["mediawiki.page.startup",
"mediawiki.util"]],["mediawiki.action.view.metadata","1456197848"],["mediawiki.action.view.postEdit","1456197848",["jquery.cookie","mediawiki.jqueryMsg"]],["mediawiki.action.view.redirectToFragment","1456197848",["jquery.client"]],["mediawiki.action.view.rightClickEdit","1456197848"],["mediawiki.action.edit.editWarning","1456197848",["mediawiki.jqueryMsg"]],["mediawiki.action.watch.ajax","1456172624",["mediawiki.page.watch.ajax"]],["mediawiki.language","1456197848",["mediawiki.cldr","mediawiki.language.data"]],["mediawiki.cldr","1456197848",["mediawiki.libs.pluralruleparser"]],["mediawiki.libs.pluralruleparser","1456197848"],["mediawiki.language.init","1456197848"],["mediawiki.jqueryMsg","1456197848",["mediawiki.language","mediawiki.util"]],["mediawiki.language.months","1456197848",["mediawiki.language"]],["mediawiki.libs.jpegmeta","1456197848"],["mediawiki.page.gallery","1456197848"],["mediawiki.page.ready","1456197848",["jquery.checkboxShiftClick","jquery.makeCollapsible",
"jquery.mw-jump","jquery.placeholder","mediawiki.util"]],["mediawiki.page.startup","1456197848",["mediawiki.util"]],["mediawiki.page.patrol.ajax","1456257924",["jquery.spinner","mediawiki.Title","mediawiki.api","mediawiki.notify","mediawiki.page.startup","mediawiki.util","user.tokens"]],["mediawiki.page.watch.ajax","1456197848",["jquery.mwExtension","mediawiki.api.watch","mediawiki.notify","mediawiki.page.startup","mediawiki.util"]],["mediawiki.page.image.pagination","1456197848",["jquery.spinner","mediawiki.Uri","mediawiki.util"]],["mediawiki.special","1456197848"],["mediawiki.special.block","1456197848",["mediawiki.util"]],["mediawiki.special.changeemail","1456197848",["mediawiki.util"]],["mediawiki.special.changeslist","1456197848"],["mediawiki.special.changeslist.legend","1456197848"],["mediawiki.special.changeslist.legend.js","1456197848",["jquery.cookie","jquery.makeCollapsible"]],["mediawiki.special.changeslist.enhanced","1456197848"],["mediawiki.special.movePage","1456197848",[
"jquery.byteLimit"]],["mediawiki.special.pagesWithProp","1456197848"],["mediawiki.special.preferences","1456207223",["mediawiki.language"]],["mediawiki.special.recentchanges","1456197848",["mediawiki.special"]],["mediawiki.special.search","1456197848"],["mediawiki.special.undelete","1456197848"],["mediawiki.special.upload","1456212629",["mediawiki.libs.jpegmeta","mediawiki.util"]],["mediawiki.special.userlogin.common.styles","1456197848"],["mediawiki.special.userlogin.signup.styles","1456197848"],["mediawiki.special.userlogin.login.styles","1456197848"],["mediawiki.special.userlogin.common.js","1456197848"],["mediawiki.special.userlogin.signup.js","1456197848",["jquery.throttle-debounce","mediawiki.api","mediawiki.jqueryMsg"]],["mediawiki.special.javaScriptTest","1456197848",["mediawiki.Uri"]],["mediawiki.special.version","1456197848"],["mediawiki.legacy.ajax","1456197848",["mediawiki.legacy.wikibits","mediawiki.util"]],["mediawiki.legacy.commonPrint","1456197848"],[
"mediawiki.legacy.config","1456197848",["mediawiki.legacy.wikibits"]],["mediawiki.legacy.protect","1456197848",["jquery.byteLimit"]],["mediawiki.legacy.shared","1456197848"],["mediawiki.legacy.oldshared","1456197848"],["mediawiki.legacy.upload","1456197848",["jquery.spinner","mediawiki.Title","mediawiki.api","mediawiki.util"]],["mediawiki.legacy.wikibits","1456197848",["mediawiki.util"]],["mediawiki.ui","1456197848"],["mediawiki.ui.button","1456197848"],["oojs","1456197848"],["oojs-ui","1456197848",["oojs"]],["ext.nuke","1456197848"],["ext.geshi.local","1456197848"],["jquery.wikiEditor","1456197848",["jquery.client","jquery.textSelection"],"ext.wikiEditor"],["jquery.wikiEditor.dialogs","1456197848",["jquery.tabIndex","jquery.ui.button","jquery.ui.dialog","jquery.ui.draggable","jquery.ui.resizable","jquery.wikiEditor","jquery.wikiEditor.toolbar"],"ext.wikiEditor"],["jquery.wikiEditor.dialogs.config","1456197848",["jquery.suggestions","jquery.wikiEditor","jquery.wikiEditor.dialogs",
"jquery.wikiEditor.toolbar.i18n","mediawiki.Title","mediawiki.jqueryMsg"],"ext.wikiEditor"],["jquery.wikiEditor.preview","1456197848",["jquery.wikiEditor"],"ext.wikiEditor"],["jquery.wikiEditor.previewDialog","1456197848",["jquery.wikiEditor","jquery.wikiEditor.dialogs"],"ext.wikiEditor"],["jquery.wikiEditor.publish","1456197848",["jquery.wikiEditor","jquery.wikiEditor.dialogs"],"ext.wikiEditor"],["jquery.wikiEditor.toolbar","1456197848",["jquery.wikiEditor","jquery.wikiEditor.toolbar.i18n"],"ext.wikiEditor"],["jquery.wikiEditor.toolbar.config","1456197848",["jquery.async","jquery.cookie","jquery.wikiEditor","jquery.wikiEditor.toolbar","jquery.wikiEditor.toolbar.i18n"],"ext.wikiEditor"],["jquery.wikiEditor.toolbar.i18n","1456172624",[],"ext.wikiEditor"],["ext.wikiEditor","1456197848",["jquery.wikiEditor"],"ext.wikiEditor"],["ext.wikiEditor.dialogs","1456197848",["ext.wikiEditor","ext.wikiEditor.toolbar","jquery.wikiEditor.dialogs","jquery.wikiEditor.dialogs.config"],"ext.wikiEditor"],[
"ext.wikiEditor.preview","1456197848",["ext.wikiEditor","jquery.wikiEditor.preview"],"ext.wikiEditor"],["ext.wikiEditor.previewDialog","1456197848",["ext.wikiEditor","jquery.wikiEditor.previewDialog"],"ext.wikiEditor"],["ext.wikiEditor.publish","1456197848",["ext.wikiEditor","jquery.wikiEditor.publish"],"ext.wikiEditor"],["ext.wikiEditor.tests.toolbar","1456197848",["ext.wikiEditor.toolbar"],"ext.wikiEditor"],["ext.wikiEditor.toolbar","1456197848",["ext.wikiEditor","jquery.wikiEditor.toolbar","jquery.wikiEditor.toolbar.config"],"ext.wikiEditor"],["ext.wikiEditor.toolbar.hideSig","1456197848",[],"ext.wikiEditor"],["skins.strapping","1456197848"]]);mw.config.set({"wgLoadScript":"/load.php","debug":false,"skin":"strapping","stylepath":"/skins","wgUrlProtocols":
"http\\:\\/\\/|https\\:\\/\\/|ftp\\:\\/\\/|ftps\\:\\/\\/|ssh\\:\\/\\/|sftp\\:\\/\\/|irc\\:\\/\\/|ircs\\:\\/\\/|xmpp\\:|sip\\:|sips\\:|gopher\\:\\/\\/|telnet\\:\\/\\/|nntp\\:\\/\\/|worldwind\\:\\/\\/|mailto\\:|tel\\:|sms\\:|news\\:|svn\\:\\/\\/|git\\:\\/\\/|mms\\:\\/\\/|bitcoin\\:|magnet\\:|urn\\:|geo\\:|\\/\\/","wgArticlePath":"/view/$1","wgScriptPath":"","wgScriptExtension":".php","wgScript":"/index.php","wgSearchType":null,"wgVariantArticlePath":false,"wgActionPaths":{},"wgServer":"https://wiki.opendaylight.org","wgUserLanguage":"en","wgContentLanguage":"en","wgVersion":"1.23.11","wgEnableAPI":true,"wgEnableWriteAPI":true,"wgMainPageTitle":"Main Page","wgFormattedNamespaces":{"-2":"Media","-1":"Special","0":"","1":"Talk","2":"User","3":"User talk","4":"OpenDaylight Project","5":"OpenDaylight Project talk","6":"File","7":"File talk","8":"MediaWiki","9":"MediaWiki talk","10":"Template","11":"Template talk","12":"Help","13":"Help talk","14":"Category","15":"Category talk","180":
"Project Proposals","181":"Project Proposals talk","274":"Widget","275":"Widget talk"},"wgNamespaceIds":{"media":-2,"special":-1,"":0,"talk":1,"user":2,"user_talk":3,"opendaylight_project":4,"opendaylight_project_talk":5,"file":6,"file_talk":7,"mediawiki":8,"mediawiki_talk":9,"template":10,"template_talk":11,"help":12,"help_talk":13,"category":14,"category_talk":15,"project_proposals":180,"project_proposals_talk":181,"widget":274,"widget_talk":275,"image":6,"image_talk":7,"project":4,"project_talk":5},"wgContentNamespaces":[0,180],"wgSiteName":"OpenDaylight Project","wgFileExtensions":["png","gif","jpg","jpeg","txt","ppt","pptx","pdf","psd","mp3","xls","xlsx","swf","doc","docx","odt","odc","odp","odg","mpp","diff","wmv","sh","arf","mov"],"wgDBname":"daylight_mwiki","wgFileCanRotate":true,"wgAvailableSkins":{"strapping":"Strapping","vector":"Vector","monobook":"MonoBook","modern":"Modern","cologneblue":"CologneBlue"},"wgExtensionAssetsPath":"/extensions","wgCookiePrefix":
"daylight_mwiki","wgResourceLoaderMaxQueryLength":-1,"wgCaseSensitiveNamespaces":[],"wgLegalTitleChars":" %!\"$\u0026'()*,\\-./0-9:;=?@A-Z\\\\\\^_`a-z~+\\u0080-\\uFFFF","wgResourceLoaderStorageVersion":1,"wgResourceLoaderStorageEnabled":false,"wgWikiEditorMagicWords":{"redirect":"#REDIRECT","img_right":"right","img_left":"left","img_none":"none","img_center":"center","img_thumbnail":"thumbnail","img_framed":"framed","img_frameless":"frameless"}});};if(isCompatible()){document.write("\u003Cscript src=\"/load.php?debug=false\u0026amp;lang=en\u0026amp;modules=jquery%2Cmediawiki\u0026amp;only=scripts\u0026amp;skin=strapping\u0026amp;version=20160223T032408Z\"\u003E\u003C/script\u003E");};
/* cache key: daylight_mwiki:resourceloader:filter:minify-js:7:37db4201b1243adf4284e269d9392703 */