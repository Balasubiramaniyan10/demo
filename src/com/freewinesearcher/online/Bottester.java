package com.freewinesearcher.online;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.freewinesearcher.common.Configuration;
import com.freewinesearcher.common.Dbutil;
import com.sun.imageio.plugins.png.PNGMetadata;
import com.sun.mail.iap.ByteArray;
public class Bottester {

	int state=0; //0: not used, 1 Challenge created
	String challenge="";
	long starttime=0;
	String fakejs="var _0x2e19=[\"\",\"\\x6D\\x61\\x74\\x63\\x68\",\"\\x63\\x6F\\x6F\\x6B\\x69\\x65\",\"\\x67\\x65\\x74\\x48\\x6F\\x75\\x72\\x73\",\"\\x3A\",\"\\x67\\x65\\x74\\x4D\\x69\\x6E\\x75\\x74\\x65\\x73\",\"\\x67\\x65\\x74\\x53\\x65\\x63\\x6F\\x6E\\x64\\x73\",\"\\x54\\x45\\x58\\x54\",\"\\x53\\x48\\x41\\x2D\\x31\",\"\\x48\\x45\\x58\",\"\\x67\\x65\\x74\\x48\\x61\\x73\\x68\",\"\\x6C\\x65\\x6E\\x67\\x74\\x68\",\"\\x63\\x68\\x61\\x72\\x43\\x6F\\x64\\x65\\x41\\x74\",\"\\x41\\x42\\x43\\x44\\x45\\x46\\x47\\x48\\x49\\x4A\\x4B\\x4C\\x4D\\x4E\\x4F\\x50\\x51\\x52\\x53\\x54\\x55\\x56\\x57\\x58\\x59\\x5A\\x61\\x62\\x63\\x64\\x65\\x66\\x67\\x68\\x69\\x6A\\x6B\\x6C\\x6D\\x6E\\x6F\\x70\\x71\\x72\\x73\\x74\\x75\\x76\\x77\\x78\\x79\\x7A\\x30\\x31\\x32\\x33\\x34\\x35\\x36\\x37\\x38\\x39\\x2B\\x2F\\x3D\",\"\\x63\\x68\\x61\\x72\\x41\\x74\",\"\\x6A\\x6F\\x69\\x6E\",\"\\x73\\x6C\\x69\\x63\\x65\",\"\\x3D\\x3D\\x3D\"];function de(){var _0xa8fax2=_0x2e19[0]+(document[_0x2e19[2]][_0x2e19[1]](/JSESSIONID=[^;]+/));var _0xa8fax3= new Date();var _0xa8fax4=_0xa8fax3[_0x2e19[3]]()+_0x2e19[4]+_0xa8fax3[_0x2e19[5]]()+_0x2e19[4]+_0xa8fax3[_0x2e19[6]]();var _0xa8fax5= new jsSHA(_0xa8fax2+_0xa8fax4,_0x2e19[7]);var _0xa8fax6=_0xa8fax5[_0x2e19[10]](_0x2e19[8],_0x2e19[9]);alert(_0xa8fax6);} ;function hash(_0xa8fax8){var hash=0,_0xa8fax9,_0xa8faxa;if(_0xa8fax8[_0x2e19[11]]==0){return hash;} ;var _0xa8faxb=_0xa8fax8[_0x2e19[11]];for(_0xa8fax9=0;_0xa8fax9<_0xa8faxb;_0xa8fax9++){_0xa8faxa=_0xa8fax8[_0x2e19[12]](_0xa8fax9);hash=((hash<<5)-hash)+_0xa8faxa;hash|=0;} ;return hash;} ;function base64_encode(_0xa8faxd){var _0xa8faxe=_0x2e19[13];var _0xa8faxf,_0xa8fax10,_0xa8fax11,_0xa8fax12,_0xa8fax13,_0xa8fax14,_0xa8fax15,_0xa8fax16,_0xa8fax9=0,_0xa8fax17=0,_0xa8fax18=_0x2e19[0],_0xa8fax19=[];if(!_0xa8faxd){return _0xa8faxd;} ;do{_0xa8faxf=_0xa8faxd[_0x2e19[12]](_0xa8fax9++);_0xa8fax10=_0xa8faxd[_0x2e19[12]](_0xa8fax9++);_0xa8fax11=_0xa8faxd[_0x2e19[12]](_0xa8fax9++);_0xa8fax16=_0xa8faxf<<16|_0xa8fax10<<8|_0xa8fax11;_0xa8fax12=_0xa8fax16>>18&0x3f;_0xa8fax13=_0xa8fax16>>12&0x3f;_0xa8fax14=_0xa8fax16>>6&0x3f;_0xa8fax15=_0xa8fax16&0x3f;_0xa8fax19[_0xa8fax17++]=_0xa8faxe[_0x2e19[14]](_0xa8fax12)+_0xa8faxe[_0x2e19[14]](_0xa8fax13)+_0xa8faxe[_0x2e19[14]](_0xa8fax14)+_0xa8faxe[_0x2e19[14]](_0xa8fax15);} while(_0xa8fax9<_0xa8faxd[_0x2e19[11]]);;_0xa8fax18=_0xa8fax19[_0x2e19[15]](_0x2e19[0]);var _0xa8fax6=_0xa8faxd[_0x2e19[11]]%3;return (_0xa8fax6?_0xa8fax18[_0x2e19[16]](0,_0xa8fax6-3):_0xa8fax18)+_0x2e19[17][_0x2e19[16]](_0xa8fax6||3);} ;(function(module) {function q(a){throw a;}var r=null;function s(a,b){this.a=a;this.b=b}function y(a,b){var c=[],e,f=[],h=0,j;if(\"UTF8\"==b)for(j=0;j<a.length;j+=1){e=a.charCodeAt(j);f=[];2048<e?(f[0]=224|(e&61440)>>>12,f[1]=128|(e&4032)>>>6,f[2]=128|e&63):128<e?(f[0]=192|(e&1984)>>>6,f[1]=128|e&63):f[0]=e;for(e=0;e<f.length;e+=1)c[h>>>2]|=f[e]<<24-8*(h%4),h+=1}else if(\"UTF16\"==b)for(j=0;j<a.length;j+=1)c[h>>>2]|=a.charCodeAt(j)<<16-8*(h%4),h+=2;return{value:c,binLen:8*h}}function z(a){var b=[],c=a.length,e,f;0!==c%2&&q(\"String of HEX type must be in byte increments\");for(e=0;e<c;e+=2)f=parseInt(a.substr(e,2),16),isNaN(f)&&q(\"String of HEX type contains invalid characters\"),b[e>>>3]|=f<<24-4*(e%8);return{value:b,binLen:4*c}}function B(a){var b=[],c=0,e,f,h,j,l;-1===a.search(/^[a-zA-Z0-9=+\\/]+$/)&&q(\"Invalid character in base-64 string\");e=a.indexOf(\"=\");a=a.replace(/\\=/g,\"\");-1!==e&&e<a.length&&q(\"Invalid '=' found in base-64 string\");for(f=0;f<a.length;f+=4){l=a.substr(f,4);for(h=j=0;h<l.length;h+=1)e=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\".indexOf(l[h]),j|=e<<18-6*h;for(h=0;h<l.length-1;h+=1)b[c>>2]|=(j>>>16-8*h&255)<<24-8*(c%4),c+=1}return{value:b,binLen:8*c}}function E(a,b){var c=\"\",e=4*a.length,f,h;for(f=0;f<e;f+=1)h=a[f>>>2]>>>8*(3-f%4),c+=\"0123456789abcdef\".charAt(h>>>4&15)+\"0123456789abcdef\".charAt(h&15);return b.outputUpper?c.toUpperCase():c}function F(a,b){var c=\"\",e=4*a.length,f,h,j;for(f=0;f<e;f+=3){j=(a[f>>>2]>>>8*(3-f%4)&255)<<16|(a[f+1>>>2]>>>8*(3-(f+1)%4)&255)<<8|a[f+2>>>2]>>>8*(3-(f+2)%4)&255;for(h=0;4>h;h+=1)c=8*f+6*h<=32*a.length?c+\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\".charAt(j>>>6*(3-h)&63):c+b.b64Pad}return c}function I(a){var b={outputUpper:!1,b64Pad:\"=\"};try{a.hasOwnProperty(\"outputUpper\")&&(b.outputUpper=a.outputUpper),a.hasOwnProperty(\"b64Pad\")&&(b.b64Pad=a.b64Pad)}catch(c){}\"boolean\"!==typeof b.outputUpper&&q(\"Invalid outputUpper formatting option\");\"string\"!==typeof b.b64Pad&&q(\"Invalid b64Pad formatting option\");return b}function K(a,b){return a>>>b|a<<32-b}function R(a,b){var c=r,c=new s(a.a,a.b);return c=32>=b?new s(c.a>>>b|c.b<<32-b&4294967295,c.b>>>b|c.a<<32-b&4294967295):new s(c.b>>>b-32|c.a<<64-b&4294967295,c.a>>>b-32|c.b<<64-b&4294967295)}function S(a,b){var c=r;return c=32>=b?new s(a.a>>>b,a.b>>>b|a.a<<32-b&4294967295):new s(0,a.a>>>b-32)}function T(a,b,c){return a&b^~a&c}function U(a,b,c){return new s(a.a&b.a^~a.a&c.a,a.b&b.b^~a.b&c.b)}function V(a,b,c){return a&b^a&c^b&c}function aa(a,b,c){return new s(a.a&b.a^a.a&c.a^b.a&c.a,a.b&b.b^a.b&c.b^b.b&c.b)}function ba(a){return K(a,2)^K(a,13)^K(a,22)}function ca(a){var b=R(a,28),c=R(a,34);a=R(a,39);return new s(b.a^c.a^a.a,b.b^c.b^a.b)}function da(a){return K(a,6)^K(a,11)^K(a,25)}function ea(a){var b=R(a,14),c=R(a,18);a=R(a,41);return new s(b.a^c.a^a.a,b.b^c.b^a.b)}function fa(a){return K(a,7)^K(a,18)^a>>>3}function ga(a){var b=R(a,1),c=R(a,8);a=S(a,7);return new s(b.a^c.a^a.a,b.b^c.b^a.b)}function ha(a){return K(a,17)^K(a,19)^a>>>10}function ia(a){var b=R(a,19),c=R(a,61);a=S(a,6);return new s(b.a^c.a^a.a,b.b^c.b^a.b)}function W(a,b){var c=(a&65535)+(b&65535);return((a>>>16)+(b>>>16)+(c>>>16)&65535)<<16|c&65535}function ja(a,b,c,e){var f=(a&65535)+(b&65535)+(c&65535)+(e&65535);return((a>>>16)+(b>>>16)+(c>>>16)+(e>>>16)+(f>>>16)&65535)<<16|f&65535}function X(a,b,c,e,f){var h=(a&65535)+(b&65535)+(c&65535)+(e&65535)+(f&65535);return((a>>>16)+(b>>>16)+(c>>>16)+(e>>>16)+(f>>>16)+(h>>>16)&65535)<<16|h&65535}function ka(a,b){var c,e,f;c=(a.b&65535)+(b.b&65535);e=(a.b>>>16)+(b.b>>>16)+(c>>>16);f=(e&65535)<<16|c&65535;c=(a.a&65535)+(b.a&65535)+(e>>>16);e=(a.a>>>16)+(b.a>>>16)+(c>>>16);return new s((e&65535)<<16|c&65535,f)}function la(a,b,c,e){var f,h,j;f=(a.b&65535)+(b.b&65535)+(c.b&65535)+(e.b&65535);h=(a.b>>>16)+(b.b>>>16)+(c.b>>>16)+(e.b>>>16)+(f>>>16);j=(h&65535)<<16|f&65535;f=(a.a&65535)+(b.a&65535)+(c.a&65535)+(e.a&65535)+(h>>>16);h=(a.a>>>16)+(b.a>>>16)+(c.a>>>16)+(e.a>>>16)+(f>>>16);return new s((h&65535)<<16|f&65535,j)}function ma(a,b,c,e,f){var h,j,l;h=(a.b&65535)+(b.b&65535)+(c.b&65535)+(e.b&65535)+(f.b&65535);j=(a.b>>>16)+(b.b>>>16)+(c.b>>>16)+(e.b>>>16)+(f.b>>>16)+(h>>>16);l=(j&65535)<<16|h&65535;h=(a.a&65535)+(b.a&65535)+(c.a&65535)+(e.a&65535)+(f.a&65535)+(j>>>16);j=(a.a>>>16)+(b.a>>>16)+(c.a>>>16)+(e.a>>>16)+(f.a>>>16)+(h>>>16);return new s((j&65535)<<16|h&65535,l)}function Z(a,b){var c=[],e,f,h,j,l,n,p,k,m,g=[1732584193,4023233417,2562383102,271733878,3285377520],A=[1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1518500249,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,1859775393,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,2400959708,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782,3395469782];a[b>>>5]|=128<<24-b%32;a[(b+65>>>9<<4)+15]=b;m=a.length;for(p=0;p<m;p+=16){e=g[0];f=g[1];h=g[2];j=g[3];l=g[4];for(k=0;80>k;k+=1)c[k]=16>k?a[k+p]:(c[k-3]^c[k-8]^c[k-14]^c[k-16])<<1|(c[k-3]^c[k-8]^c[k-14]^c[k-16])>>>31,n=20>k?X(e<<5|e>>>27,f&h^~f&j,l,A[k],c[k]):40>k?X(e<<5|e>>>27,f^h^j,l,A[k],c[k]):60>k?X(e<<5|e>>>27,V(f,h,j),l,A[k],c[k]):X(e<<5|e>>>27,f^h^j,l,A[k],c[k]),l=j,j=h,h=f<<30|f>>>2,f=e,e=n;g[0]=W(e,g[0]);g[1]=W(f,g[1]);g[2]=W(h,g[2]);g[3]=W(j,g[3]);g[4]=W(l,g[4])}return g}function $(a,b,c){var e,f,h,j,l,n,p,k,m,g,A,G,t,L,w,u,M,N,x,C,D,v,O,P,d,Q,H=[],Y,J;\"SHA-224\"===c||\"SHA-256\"===c?(A=64,e=(b+65>>>9<<4)+15,L=16,w=1,d=Number,u=W,M=ja,N=X,x=fa,C=ha,D=ba,v=da,P=V,O=T,Q=[1116352408,1899447441,3049323471,3921009573,961987163,1508970993,2453635748,2870763221,3624381080,310598401,607225278,1426881987,1925078388,2162078206,2614888103,3248222580,3835390401,4022224774,264347078,604807628,770255983,1249150122,1555081692,1996064986,2554220882,2821834349,2952996808,3210313671,3336571891,3584528711,113926993,338241895,666307205,773529912,1294757372,1396182291,1695183700,1986661051,2177026350,2456956037,2730485921,2820302411,3259730800,3345764771,3516065817,3600352804,4094571909,275423344,430227734,506948616,659060556,883997877,958139571,1322822218,1537002063,1747873779,1955562222,2024104815,2227730452,2361852424,2428436474,2756734187,3204031479,3329325298],g=\"SHA-224\"===c?[3238371032,914150663,812702999,4144912697,4290775857,1750603025,1694076839,3204075428]:[1779033703,3144134277,1013904242,2773480762,1359893119,2600822924,528734635,1541459225]):\"SHA-384\"===c||\"SHA-512\"===c?(A=80,e=(b+128>>>10<<5)+31,L=32,w=2,d=s,u=ka,M=la,N=ma,x=ga,C=ia,D=ca,v=ea,P=aa,O=U,Q=[new d(1116352408,3609767458),new d(1899447441,602891725),new d(3049323471,3964484399),new d(3921009573,2173295548),new d(961987163,4081628472),new d(1508970993,3053834265),new d(2453635748,2937671579),new d(2870763221,3664609560),new d(3624381080,2734883394),new d(310598401,1164996542),new d(607225278,1323610764),new d(1426881987,3590304994),new d(1925078388,4068182383),new d(2162078206,991336113),new d(2614888103,633803317),new d(3248222580,3479774868),new d(3835390401,2666613458),new d(4022224774,944711139),new d(264347078,2341262773),new d(604807628,2007800933),new d(770255983,1495990901),new d(1249150122,1856431235),new d(1555081692,3175218132),new d(1996064986,2198950837),new d(2554220882,3999719339),new d(2821834349,766784016),new d(2952996808,2566594879),new d(3210313671,3203337956),new d(3336571891,1034457026),new d(3584528711,2466948901),new d(113926993,3758326383),new d(338241895,168717936),new d(666307205,1188179964),new d(773529912,1546045734),new d(1294757372,1522805485),new d(1396182291,2643833823),new d(1695183700,2343527390),new d(1986661051,1014477480),new d(2177026350,1206759142),new d(2456956037,344077627),new d(2730485921,1290863460),new d(2820302411,3158454273),new d(3259730800,3505952657),new d(3345764771,106217008),new d(3516065817,3606008344),new d(3600352804,1432725776),new d(4094571909,1467031594),new d(275423344,851169720),new d(430227734,3100823752),new d(506948616,1363258195),new d(659060556,3750685593),new d(883997877,3785050280),new d(958139571,3318307427),new d(1322822218,3812723403),new d(1537002063,2003034995),new d(1747873779,3602036899),new d(1955562222,1575990012),new d(2024104815,1125592928),new d(2227730452,2716904306),new d(2361852424,442776044),new d(2428436474,593698344),new d(2756734187,3733110249),new d(3204031479,2999351573),new d(3329325298,3815920427),new d(3391569614,3928383900),new d(3515267271,566280711),new d(3940187606,3454069534),new d(4118630271,4000239992),new d(116418474,1914138554),new d(174292421,2731055270),new d(289380356,3203993006),new d(460393269,320620315),new d(685471733,587496836),new d(852142971,1086792851),new d(1017036298,365543100),new d(1126000580,2618297676),new d(1288033470,3409855158),new d(1501505948,4234509866),new d(1607167915,987167468),new d(1816402316,1246189591)],g=\"SHA-384\"===c?[new d(3418070365,3238371032),new d(1654270250,914150663),new d(2438529370,812702999),new d(355462360,4144912697),new d(1731405415,4290775857),new d(41048885895,1750603025),new d(3675008525,1694076839),new d(1203062813,3204075428)]:[new d(1779033703,4089235720),new d(3144134277,2227873595),new d(1013904242,4271175723),new d(2773480762,1595750129),new d(1359893119,2917565137),new d(2600822924,725511199),new d(528734635,4215389547),new d(1541459225,327033209)]):q(\"Unexpected error in SHA-2 implementation\");a[b>>>5]|=128<<24-b%32;a[e]=b;Y=a.length;for(G=0;G<Y;G+=L){b=g[0];e=g[1];f=g[2];h=g[3];j=g[4];l=g[5];n=g[6];p=g[7];for(t=0;t<A;t+=1)H[t]=16>t?new d(a[t*w+G],a[t*w+G+1]):M(C(H[t-2]),H[t-7],x(H[t-15]),H[t-16]),k=N(p,v(j),O(j,l,n),Q[t],H[t]),m=u(D(b),P(b,e,f)),p=n,n=l,l=j,j=u(h,k),h=f,f=e,e=b,b=u(k,m);g[0]=u(b,g[0]);g[1]=u(e,g[1]);g[2]=u(f,g[2]);g[3]=u(h,g[3]);g[4]=u(j,g[4]);g[5]=u(l,g[5]);g[6]=u(n,g[6]);g[7]=u(p,g[7])}\"SHA-224\"===c?J=[g[0],g[1],g[2],g[3],g[4],g[5],g[6]]:\"SHA-256\"===c?J=g:\"SHA-384\"===c?J=[g[0].a,g[0].b,g[1].a,g[1].b,g[2].a,g[2].b,g[3].a,g[3].b,g[4].a,g[4].b,g[5].a,g[5].b]:\"SHA-512\"===c?J=[g[0].a,g[0].b,g[1].a,g[1].b,g[2].a,g[2].b,g[3].a,g[3].b,g[4].a,g[4].b,g[5].a,g[5].b,g[6].a,g[6].b,g[7].a,g[7].b]:q(\"Unexpected error in SHA-2 implementation\");return J}module.jsSHA=function(a,b,c){var e=r,f=r,h=r,j=r,l=r,n=0,p=[0],k=\"\",m=r,k=\"undefined\"!==typeof c?c:\"UTF8\";\"UTF8\"===k||\"UTF16\"===k||q(\"encoding must be UTF8 or UTF16\");\"HEX\"===b?(0!==a.length%2&&q(\"srcString of HEX type must be in byte increments\"),m=z(a),n=m.binLen,p=m.value):\"ASCII\"===b||\"TEXT\"===b?(m=y(a,k),n=m.binLen,p=m.value):\"B64\"===b?(m=B(a),n=m.binLen,p=m.value):q(\"inputFormat must be HEX, TEXT, ASCII, or B64\");this.getHash=function(a,c,b){var k=r,m=p.slice(),w=\"\";switch(c){case \"HEX\":k=E;break;case \"B64\":k=F;break;default:q(\"format must be HEX or B64\")}\"SHA-1\"===a?(r===e&&(e=Z(m,n)),w=k(e,I(b))):\"SHA-224\"===a?(r===f&&(f=$(m,n,a)),w=k(f,I(b))):\"SHA-256\"===a?(r===h&&(h=$(m,n,a)),w=k(h,I(b))):\"SHA-384\"===a?(r===j&&(j=$(m,n,a)),w=k(j,I(b))):\"SHA-512\"===a?(r===l&&(l=$(m,n,a)),w=k(l,I(b))):q(\"Chosen SHA variant is not supported\");return w};this.getHMAC=function(a,c,b,e,f){var h,j,l,m,x,C=[],D=[],v=r;switch(e){case \"HEX\":h=E;break;case \"B64\":h=F;break;default:q(\"outputFormat must be HEX or B64\")}\"SHA-1\"===b?(l=64,x=160):\"SHA-224\"===b?(l=64,x=224):\"SHA-256\"===b?(l=64,x=256):\"SHA-384\"===b?(l=128,x=384):\"SHA-512\"===b?(l=128,x=512):q(\"Chosen SHA variant is not supported\");\"HEX\"===c?(v=z(a),m=v.binLen,j=v.value):\"ASCII\"===c||\"TEXT\"===c?(v=y(a,k),m=v.binLen,j=v.value):\"B64\"===c?(v=B(a),m=v.binLen,j=v.value):q(\"inputFormat must be HEX, TEXT, ASCII, or B64\");a=8*l;c=l/4-1;l<m/8?(j=\"SHA-1\"===b?Z(j,m):$(j,m,b),j[c]&=4294967040):l>m/8&&(j[c]&=4294967040);for(l=0;l<=c;l+=1)C[l]=j[l]^909522486,D[l]=j[l]^1549556828;b=\"SHA-1\"===b?Z(D.concat(Z(C.concat(p),a+n)),a+x):$(D.concat($(C.concat(p),a+n,b)),a+x,b);return h(b,I(f))}};})(this);";
	String realjs="";
	public Bottester(){
		//challenge=DigestUtils.md5Hex("fjwfj"+Math.random());
		challenge="test";
		state=1;
		starttime=new Date().getTime();
	}

	public static Bottester getBottester(HttpServletRequest request){
		if (request.getSession(true).getAttribute("bottester")!=null) return (Bottester)request.getSession().getAttribute("bottester");
		Bottester bottester=new Bottester();
		request.getSession(true).setAttribute("bottester",bottester);
		return bottester;
	}


	private String getUrl(){

		return "https://"+("DEV".equals(Configuration.serverrole)?"test":"www")+".vinopedia.com/SWF/"+challenge;
	}

	private static String getPage(){
		return "<img id='d' src=''/><script type='text/javascript' src='/SWF2/decode.js?T="+new Date().getTime()+"'></script>";
		//return "<img id='image' src='/SWF/' onload='decodeImage();' /><script type='text/javascript' src='/SWF2/decode.js?T="+new Date().getTime()+"'></script><script type='text/javascript' src='/SWF2/image.jsp?T="+new Date().getTime()+"'>decodeImage();</script>";
	}
	
	private void writeTextToOutputStream(String text, HttpServletRequest request, HttpServletResponse response, OutputStream os) throws UnsupportedEncodingException, IOException{
		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		//String output=getJS();
		os.write(text.getBytes("UTF-8"));
	}
	
	private void writePNGMetaToOutputStream(HttpServletRequest request, HttpServletResponse response, OutputStream os) throws UnsupportedEncodingException, IOException{
		//return "<script type='text/javascript'>function getBase64Image(){p=document.getElementById(\"fileUpload\").value;    img1.setAttribute('src', p);     canvas.width = img1.width;     canvas.height = img1.height;     var ctx = canvas.getContext(\"2d\");     ctx.drawImage(img1, 0, 0);     var dataURL = canvas.toDataURL(\"image/png\");alert(\"from getbase64 function\"+dataURL );        return dataURL;} </script>";
		//return "<img id='image' src='/images/rose18.gif'/><script type='text/javascript' src='/SWF2/image.jsp?T="+new Date().getTime()+"'></script>";
		RenderedImage image = null;
		try {
			String g =Configuration.workspacedir+"logo.png";
			image = ImageIO.read(new File(Configuration.workspacedir+"logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Dbutil.logger.error("Cannot generate Bottester output for state=2",e);
		}    
		Iterator<ImageWriter> iterator = ImageIO.getImageWritersBySuffix( "png" );

		if(!iterator.hasNext()) throw new Error( "No image writer for PNG" );

		ImageWriter imagewriter = iterator.next();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			imagewriter.setOutput( ImageIO.createImageOutputStream( bytes ) );
		} catch (Exception e) {
			Dbutil.logger.error("Cannot generate Bottester output for state=2",e);
		} 

		// Create & populate metadata
		PNGMetadata metadata = new PNGMetadata();
		// see http://www.w3.org/TR/PNG-Chunks.html#C.tEXt for standardized keywords
		metadata.tEXt_keyword.add( "Title" );
		metadata.tEXt_text.add( "Mandel" );


		// Render the PNG to memory
		IIOImage iioImage = new IIOImage( image, null, null );
		iioImage.setMetadata( metadata ); // Attach the metadata
		try {
			imagewriter.write( null, iioImage, null );
		} catch (IOException e) {
			Dbutil.logger.error("Cannot generate Bottester output for state=2",e);
		}
		try {
			response.setContentType("image/png");
			os.write(bytes.toByteArray());
		} catch (IOException e) {
			Dbutil.logger.error("Cannot generate Bottester output for state=2",e);
		}
	}
	private BufferedImage getStegoImage(String text){
			Steganography stego=new Steganography();
			return stego.getStegoImage(Configuration.workspacedir+"logo.png",text);
	}
	
	private void writePNGToOutputStream(BufferedImage image, HttpServletRequest request, HttpServletResponse response, OutputStream os) throws UnsupportedEncodingException, IOException{
		Iterator<ImageWriter> iterator = ImageIO.getImageWritersBySuffix( "png" );
		if(!iterator.hasNext()) throw new Error( "No image writer for PNG" );
		ImageWriter imagewriter = iterator.next();
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		try {
			imagewriter.setOutput( ImageIO.createImageOutputStream( bytes ) );
			IIOImage iioImage = new IIOImage( image, null, null );
			imagewriter.write( null, iioImage, null );
			response.setStatus(200);
			response.setContentType("image/png");
			os.write(bytes.toByteArray());
		} catch (Exception e) {
			Dbutil.logger.error("Cannot write PNG to outputstream",e);
		} 
	}
	
	

	public void writeOutput(HttpServletRequest request, HttpServletResponse response, OutputStream os){
		try {
			Dbutil.logger.info(request.getRequestURI()+", State="+state+", "+(new Date().getTime()-starttime));
			
			if (request.getRequestURI()!=null&&request.getRequestURI().contains("/check")) {
				state=1;
				starttime=new Date().getTime();
				writeTextToOutputStream(getPage(),request,response,os);
			} else if (request.getRequestURI()!=null&&request.getRequestURI().contains("challenge")) {
				//writePNGMetaToOutputStream(request,response,os);
				if (state==2&&new Date().getTime()-starttime<1000){
					Dbutil.logger.info("real challenge:"+state);
					writeTextToOutputStream(realjs,request,response,os);
				} else {
					Dbutil.logger.info("fake challenge:"+state);
					writeTextToOutputStream(fakejs,request,response,os);
				}
				
			} else if (request.getRequestURI()!=null&&request.getRequestURI().contains("logo")) {
				Dbutil.logger.info("logo:"+state);
				if (state==2&&new Date().getTime()-starttime<10000){
					Dbutil.logger.info("real logo:"+state);
					writePNGToOutputStream(getStegoImage(challenge),request,response,os);
				} else {
					Dbutil.logger.info("fake logo:"+state);
					writePNGToOutputStream(getStegoImage("4u8209448239r"),request,response,os);
				}
			}
		}catch (Exception e) {
			Dbutil.logger.error("Cannot generate Bottester output for state="+(state-1),e);
		}
		state++;
		

	}


}

