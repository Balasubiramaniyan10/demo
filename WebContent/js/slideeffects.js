/*
 * jquery.tools 1.1.2 - The missing UI library for the Web
 * 
 * [tools.tabs-1.0.4, tools.tooltip-1.1.2, tools.scrollable-1.1.2, tools.scrollable.mousewheel-1.0.1]
 * 
 * Copyright (c) 2009 Tero Piirainen
 * http://flowplayer.org/tools/
 *
 * Dual licensed under MIT and GPL 2+ licenses
 * http://www.opensource.org/licenses
 * 
 * -----
 * 
 * jquery.event.wheel.js - rev 1 
 * Copyright (c) 2008, Three Dub Media (http://threedubmedia.com)
 * Liscensed under the MIT License (MIT-LICENSE.txt)
 * http://www.opensource.org/licenses/mit-license.php
 * Created: 2008-07-01 | Updated: 2008-07-14
 * 
 * -----
 * 
 * File generated: Fri Oct 09 13:02:01 GMT+00:00 2009
 */
(function(d){d.tools=d.tools||{};d.tools.tabs={version:"1.0.4",conf:{tabs:"a",current:"current",onBeforeClick:null,onClick:null,effect:"default",initialIndex:0,event:"click",api:false,rotate:false},addEffect:function(e,f){c[e]=f}};var c={"default":function(f,e){this.getPanes().hide().eq(f).show();e.call()},fade:function(g,e){var f=this.getConf(),j=f.fadeOutSpeed,h=this.getPanes();if(j){h.fadeOut(j)}else{h.hide()}h.eq(g).fadeIn(f.fadeInSpeed,e)},slide:function(f,e){this.getPanes().slideUp(200);this.getPanes().eq(f).slideDown(400,e)},ajax:function(f,e){this.getPanes().eq(0).load(this.getTabs().eq(f).attr("href"),e)}};var b;d.tools.tabs.addEffect("horizontal",function(f,e){if(!b){b=this.getPanes().eq(0).width()}this.getCurrentPane().animate({width:0},function(){d(this).hide()});this.getPanes().eq(f).animate({width:b},function(){d(this).show();e.call()})});function a(g,h,f){var e=this,j=d(this),i;d.each(f,function(k,l){if(d.isFunction(l)){j.bind(k,l)}});d.extend(this,{click:function(k,n){var o=e.getCurrentPane();var l=g.eq(k);if(typeof k=="string"&&k.replace("#","")){l=g.filter("[href*="+k.replace("#","")+"]");k=Math.max(g.index(l),0)}if(f.rotate){var m=g.length-1;if(k<0){return e.click(m,n)}if(k>m){return e.click(0,n)}}if(!l.length){if(i>=0){return e}k=f.initialIndex;l=g.eq(k)}if(k===i){return e}n=n||d.Event();n.type="onBeforeClick";j.trigger(n,[k]);if(n.isDefaultPrevented()){return}c[f.effect].call(e,k,function(){n.type="onClick";j.trigger(n,[k])});n.type="onStart";j.trigger(n,[k]);if(n.isDefaultPrevented()){return}i=k;g.removeClass(f.current);l.addClass(f.current);return e},getConf:function(){return f},getTabs:function(){return g},getPanes:function(){return h},getCurrentPane:function(){return h.eq(i)},getCurrentTab:function(){return g.eq(i)},getIndex:function(){return i},next:function(){return e.click(i+1)},prev:function(){return e.click(i-1)},bind:function(k,l){j.bind(k,l);return e},onBeforeClick:function(k){return this.bind("onBeforeClick",k)},onClick:function(k){return this.bind("onClick",k)},unbind:function(k){j.unbind(k);return e}});g.each(function(k){d(this).bind(f.event,function(l){e.click(k,l);return false})});if(location.hash){e.click(location.hash)}else{if(f.initialIndex===0||f.initialIndex>0){e.click(f.initialIndex)}}h.find("a[href^=#]").click(function(k){e.click(d(this).attr("href"),k)})}d.fn.tabs=function(i,f){var g=this.eq(typeof f=="number"?f:0).data("tabs");if(g){return g}if(d.isFunction(f)){f={onBeforeClick:f}}var h=d.extend({},d.tools.tabs.conf),e=this.length;f=d.extend(h,f);this.each(function(l){var j=d(this);var k=j.find(f.tabs);if(!k.length){k=j.children()}var m=i.jquery?i:j.children(i);if(!m.length){m=e==1?d(i):j.parent().find(i)}g=new a(k,m,f);j.data("tabs",g)});return f.api?g:this}})(jQuery);
(function(c){var d=[];c.tools=c.tools||{};c.tools.tooltip={version:"1.1.2",conf:{effect:"toggle",fadeOutSpeed:"fast",tip:null,predelay:0,delay:30,opacity:1,lazy:undefined,position:["top","center"],offset:[0,0],cancelDefault:true,relative:false,oneInstance:true,events:{def:"mouseover,mouseout",input:"focus,blur",widget:"focus mouseover,blur mouseout",tooltip:"mouseover,mouseout"},api:false},addEffect:function(e,g,f){b[e]=[g,f]}};var b={toggle:[function(e){var f=this.getConf(),g=this.getTip(),h=f.opacity;if(h<1){g.css({opacity:h})}g.show();e.call()},function(e){this.getTip().hide();e.call()}],fade:[function(e){this.getTip().fadeIn(this.getConf().fadeInSpeed,e)},function(e){this.getTip().fadeOut(this.getConf().fadeOutSpeed,e)}]};function a(f,g){var p=this,k=c(this);f.data("tooltip",p);var l=f.next();if(g.tip){l=c(g.tip);if(l.length>1){l=f.nextAll(g.tip).eq(0);if(!l.length){l=f.parent().nextAll(g.tip).eq(0)}}}function o(u){var t=g.relative?f.position().top:f.offset().top,s=g.relative?f.position().left:f.offset().left,v=g.position[0];t-=l.outerHeight()-g.offset[0];s+=f.outerWidth()+g.offset[1];var q=l.outerHeight()+f.outerHeight();if(v=="center"){t+=q/2}if(v=="bottom"){t+=q}v=g.position[1];var r=l.outerWidth()+f.outerWidth();if(v=="center"){s-=r/2}if(v=="left"){s-=r}return{top:t,left:s}}var i=f.is(":input"),e=i&&f.is(":checkbox, :radio, select, :button"),h=f.attr("type"),n=g.events[h]||g.events[i?(e?"widget":"input"):"def"];n=n.split(/,\s*/);if(n.length!=2){throw"Tooltip: bad events configuration for "+h}f.bind(n[0],function(r){if(g.oneInstance){c.each(d,function(){this.hide()})}var q=l.data("trigger");if(q&&q[0]!=this){l.hide().stop(true,true)}r.target=this;p.show(r);n=g.events.tooltip.split(/,\s*/);l.bind(n[0],function(){p.show(r)});if(n[1]){l.bind(n[1],function(){p.hide(r)})}});f.bind(n[1],function(q){p.hide(q)});if(!c.browser.msie&&!i&&!g.predelay){f.mousemove(function(){if(!p.isShown()){f.triggerHandler("mouseover")}})}if(g.opacity<1){l.css("opacity",g.opacity)}var m=0,j=f.attr("title");if(j&&g.cancelDefault){f.removeAttr("title");f.data("title",j)}c.extend(p,{show:function(r){if(r){f=c(r.target)}clearTimeout(l.data("timer"));if(l.is(":animated")||l.is(":visible")){return p}function q(){l.data("trigger",f);var t=o(r);if(g.tip&&j){l.html(f.data("title"))}r=r||c.Event();r.type="onBeforeShow";k.trigger(r,[t]);if(r.isDefaultPrevented()){return p}t=o(r);l.css({position:"absolute",top:t.top,left:t.left});var s=b[g.effect];if(!s){throw'Nonexistent effect "'+g.effect+'"'}s[0].call(p,function(){r.type="onShow";k.trigger(r)})}if(g.predelay){clearTimeout(m);m=setTimeout(q,g.predelay)}else{q()}return p},hide:function(r){clearTimeout(l.data("timer"));clearTimeout(m);if(!l.is(":visible")){return}function q(){r=r||c.Event();r.type="onBeforeHide";k.trigger(r);if(r.isDefaultPrevented()){return}b[g.effect][1].call(p,function(){r.type="onHide";k.trigger(r)})}if(g.delay&&r){l.data("timer",setTimeout(q,g.delay))}else{q()}return p},isShown:function(){return l.is(":visible, :animated")},getConf:function(){return g},getTip:function(){return l},getTrigger:function(){return f},bind:function(q,r){k.bind(q,r);return p},onHide:function(q){return this.bind("onHide",q)},onBeforeShow:function(q){return this.bind("onBeforeShow",q)},onShow:function(q){return this.bind("onShow",q)},onBeforeHide:function(q){return this.bind("onBeforeHide",q)},unbind:function(q){k.unbind(q);return p}});c.each(g,function(q,r){if(c.isFunction(r)){p.bind(q,r)}})}c.prototype.tooltip=function(e){var f=this.eq(typeof e=="number"?e:0).data("tooltip");if(f){return f}var g=c.extend(true,{},c.tools.tooltip.conf);if(c.isFunction(e)){e={onBeforeShow:e}}else{if(typeof e=="string"){e={tip:e}}}e=c.extend(true,g,e);if(typeof e.position=="string"){e.position=e.position.split(/,?\s/)}if(e.lazy!==false&&(e.lazy===true||this.length>20)){this.one("mouseover",function(h){f=new a(c(this),e);f.show(h);d.push(f)})}else{this.each(function(){f=new a(c(this),e);d.push(f)})}return e.api?f:this}})(jQuery);
(function(b){b.tools=b.tools||{};b.tools.scrollable={version:"1.1.2",conf:{size:5,vertical:false,speed:400,keyboard:true,keyboardSteps:null,disabledClass:"disabled",hoverClass:null,clickable:true,activeClass:"active",easing:"swing",loop:false,items:".items",item:null,prev:".prev",next:".next",prevPage:".prevPage",nextPage:".nextPage",api:false}};var c;function a(o,m){var r=this,p=b(this),d=!m.vertical,e=o.children(),k=0,i;if(!c){c=r}b.each(m,function(s,t){if(b.isFunction(t)){p.bind(s,t)}});if(e.length>1){e=b(m.items,o)}function l(t){var s=b(t);return m.globalNav?s:o.parent().find(t)}o.data("finder",l);var f=l(m.prev),h=l(m.next),g=l(m.prevPage),n=l(m.nextPage);b.extend(r,{getIndex:function(){return k},getClickIndex:function(){var s=r.getItems();return s.index(s.filter("."+m.activeClass))},getConf:function(){return m},getSize:function(){return r.getItems().size()},getPageAmount:function(){return Math.ceil(this.getSize()/m.size)},getPageIndex:function(){return Math.ceil(k/m.size)},getNaviButtons:function(){return f.add(h).add(g).add(n)},getRoot:function(){return o},getItemWrap:function(){return e},getItems:function(){return e.children(m.item)},getVisibleItems:function(){return r.getItems().slice(k,k+m.size)},seekTo:function(s,w,t){if(s<0){s=0}if(k===s){return r}if(b.isFunction(w)){t=w}if(s>r.getSize()-m.size){return m.loop?r.begin():this.end()}var u=r.getItems().eq(s);if(!u.length){return r}var v=b.Event("onBeforeSeek");p.trigger(v,[s]);if(v.isDefaultPrevented()){return r}if(w===undefined||b.isFunction(w)){w=m.speed}function x(){if(t){t.call(r,s)}p.trigger("onSeek",[s])}if(d){e.animate({left:-u.position().left},w,m.easing,x)}else{e.animate({top:-u.position().top},w,m.easing,x)}c=r;k=s;v=b.Event("onStart");p.trigger(v,[s]);if(v.isDefaultPrevented()){return r}f.add(g).toggleClass(m.disabledClass,s===0);h.add(n).toggleClass(m.disabledClass,s>=r.getSize()-m.size);return r},move:function(u,t,s){i=u>0;return this.seekTo(k+u,t,s)},next:function(t,s){return this.move(1,t,s)},prev:function(t,s){return this.move(-1,t,s)},movePage:function(w,v,u){i=w>0;var s=m.size*w;var t=k%m.size;if(t>0){s+=(w>0?-t:m.size-t)}return this.move(s,v,u)},prevPage:function(t,s){return this.movePage(-1,t,s)},nextPage:function(t,s){return this.movePage(1,t,s)},setPage:function(t,u,s){return this.seekTo(t*m.size,u,s)},begin:function(t,s){i=false;return this.seekTo(0,t,s)},end:function(t,s){i=true;var u=this.getSize()-m.size;return u>0?this.seekTo(u,t,s):r},reload:function(){p.trigger("onReload");return r},focus:function(){c=r;return r},click:function(u){var v=r.getItems().eq(u),s=m.activeClass,t=m.size;if(u<0||u>=r.getSize()){return r}if(t==1){if(m.loop){return r.next()}if(u===0||u==r.getSize()-1){i=(i===undefined)?true:!i}return i===false?r.prev():r.next()}if(t==2){if(u==k){u--}r.getItems().removeClass(s);v.addClass(s);return r.seekTo(u,time,fn)}if(!v.hasClass(s)){r.getItems().removeClass(s);v.addClass(s);var x=Math.floor(t/2);var w=u-x;if(w>r.getSize()-t){w=r.getSize()-t}if(w!==u){return r.seekTo(w)}}return r},bind:function(s,t){p.bind(s,t);return r},unbind:function(s){p.unbind(s);return r}});b.each("onBeforeSeek,onStart,onSeek,onReload".split(","),function(s,t){r[t]=function(u){return r.bind(t,u)}});f.addClass(m.disabledClass).click(function(){r.prev()});h.click(function(){r.next()});n.click(function(){r.nextPage()});if(r.getSize()<m.size){h.add(n).addClass(m.disabledClass)}g.addClass(m.disabledClass).click(function(){r.prevPage()});var j=m.hoverClass,q="keydown."+Math.random().toString().substring(10);r.onReload(function(){if(j){r.getItems().hover(function(){b(this).addClass(j)},function(){b(this).removeClass(j)})}if(m.clickable){r.getItems().each(function(s){b(this).unbind("click.scrollable").bind("click.scrollable",function(t){if(b(t.target).is("a")){return}return r.click(s)})})}if(m.keyboard){b(document).unbind(q).bind(q,function(t){if(t.altKey||t.ctrlKey){return}if(m.keyboard!="static"&&c!=r){return}var u=m.keyboardSteps;if(d&&(t.keyCode==37||t.keyCode==39)){r.move(t.keyCode==37?-u:u);return t.preventDefault()}if(!d&&(t.keyCode==38||t.keyCode==40)){r.move(t.keyCode==38?-u:u);return t.preventDefault()}return true})}else{b(document).unbind(q)}});r.reload()}b.fn.scrollable=function(d){var e=this.eq(typeof d=="number"?d:0).data("scrollable");if(e){return e}var f=b.extend({},b.tools.scrollable.conf);d=b.extend(f,d);d.keyboardSteps=d.keyboardSteps||d.size;this.each(function(){e=new a(b(this),d);b(this).data("scrollable",e)});return d.api?e:this}})(jQuery);
(function(b){b.fn.wheel=function(e){return this[e?"bind":"trigger"]("wheel",e)};b.event.special.wheel={setup:function(){b.event.add(this,d,c,{})},teardown:function(){b.event.remove(this,d,c)}};var d=!b.browser.mozilla?"mousewheel":"DOMMouseScroll"+(b.browser.version<"1.9"?" mousemove":"");function c(e){switch(e.type){case"mousemove":return b.extend(e.data,{clientX:e.clientX,clientY:e.clientY,pageX:e.pageX,pageY:e.pageY});case"DOMMouseScroll":b.extend(e,e.data);e.delta=-e.detail/3;break;case"mousewheel":e.delta=e.wheelDelta/120;break}e.type="wheel";return b.event.handle.call(this,e,e.delta)}var a=b.tools.scrollable;a.plugins=a.plugins||{};a.plugins.mousewheel={version:"1.0.1",conf:{api:false,speed:50}};b.fn.mousewheel=function(f){var g=b.extend({},a.plugins.mousewheel.conf),e;if(typeof f=="number"){f={speed:f}}f=b.extend(g,f);this.each(function(){var h=b(this).scrollable();if(h){e=h}h.getRoot().wheel(function(i,j){h.move(j<0?1:-1,f.speed||50);return false})});return f.api?e:this}})(jQuery);
(function(b){var a=b.tools.scrollable;a.plugins=a.plugins||{};a.plugins.navigator={version:"1.0.2",conf:{navi:".navi",naviItem:null,activeClass:"active",indexed:false,api:false,idPrefix:null}};b.fn.navigator=function(d){var e=b.extend({},a.plugins.navigator.conf),c;if(typeof d=="string"){d={navi:d}}d=b.extend(e,d);this.each(function(){var i=b(this).scrollable(),f=i.getRoot(),l=f.data("finder").call(null,d.navi),g=null,k=i.getNaviButtons();if(i){c=i}i.getNaviButtons=function(){return k.add(l)};function j(){if(!l.children().length||l.data("navi")==i){l.empty();l.data("navi",i);for(var m=0;m<i.getPageAmount();m++){l.append(b("<"+(d.naviItem||"a")+"/>"))}g=l.children().each(function(n){var o=b(this);o.click(function(p){i.setPage(n);return p.preventDefault()});if(d.indexed){o.text(n)}if(d.idPrefix){o.attr("id",d.idPrefix+n)}})}else{g=d.naviItem?l.find(d.naviItem):l.children();g.each(function(n){var o=b(this);o.click(function(p){i.setPage(n);return p.preventDefault()})})}g.eq(0).addClass(d.activeClass)}i.onStart(function(o,n){var m=d.activeClass;g.removeClass(m).eq(i.getPageIndex()).addClass(m)});i.onReload(function(){j()});j();var h=g.filter("[href="+location.hash+"]");if(h.length){i.move(g.index(h))}});return d.api?c:this}})(jQuery);

/* scrollTo */
(function(d){var k=d.scrollTo=function(a,i,e){d(window).scrollTo(a,i,e)};k.defaults={axis:'xy',duration:parseFloat(d.fn.jquery)>=1.3?0:1};k.window=function(a){return d(window)._scrollable()};d.fn._scrollable=function(){return this.map(function(){var a=this,i=!a.nodeName||d.inArray(a.nodeName.toLowerCase(),['iframe','#document','html','body'])!=-1;if(!i)return a;var e=(a.contentWindow||a).document||a.ownerDocument||a;return d.browser.safari||e.compatMode=='BackCompat'?e.body:e.documentElement})};d.fn.scrollTo=function(n,j,b){if(typeof j=='object'){b=j;j=0}if(typeof b=='function')b={onAfter:b};if(n=='max')n=9e9;b=d.extend({},k.defaults,b);j=j||b.speed||b.duration;b.queue=b.queue&&b.axis.length>1;if(b.queue)j/=2;b.offset=p(b.offset);b.over=p(b.over);return this._scrollable().each(function(){var q=this,r=d(q),f=n,s,g={},u=r.is('html,body');switch(typeof f){case'number':case'string':if(/^([+-]=)?\d+(\.\d+)?(px|%)?$/.test(f)){f=p(f);break}f=d(f,this);case'object':if(f.is||f.style)s=(f=d(f)).offset()}d.each(b.axis.split(''),function(a,i){var e=i=='x'?'Left':'Top',h=e.toLowerCase(),c='scroll'+e,l=q[c],m=k.max(q,i);if(s){g[c]=s[h]+(u?0:l-r.offset()[h]);if(b.margin){g[c]-=parseInt(f.css('margin'+e))||0;g[c]-=parseInt(f.css('border'+e+'Width'))||0}g[c]+=b.offset[h]||0;if(b.over[h])g[c]+=f[i=='x'?'width':'height']()*b.over[h]}else{var o=f[h];g[c]=o.slice&&o.slice(-1)=='%'?parseFloat(o)/100*m:o}if(/^\d+$/.test(g[c]))g[c]=g[c]<=0?0:Math.min(g[c],m);if(!a&&b.queue){if(l!=g[c])t(b.onAfterFirst);delete g[c]}});t(b.onAfter);function t(a){r.animate(g,j,b.easing,a&&function(){a.call(this,n,b)})}}).end()};k.max=function(a,i){var e=i=='x'?'Width':'Height',h='scroll'+e;if(!d(a).is('html,body'))return a[h]-d(a)[e.toLowerCase()]();var c='client'+e,l=a.ownerDocument.documentElement,m=a.ownerDocument.body;return Math.max(l[h],m[h])-Math.min(l[c],m[c])};function p(a){return typeof a=='object'?a:{top:a,left:a}}})(jQuery);

