#include <jni.h>
#include <string>
#include "rtmp.h"
#include "x264.h"

using namespace std;
extern "C"
JNIEXPORT jstring JNICALL
Java_com_xcp_ffpush_MainActivity_stringFromJni(JNIEnv *env, jobject thiz) {
//    const char *hello="hello form c++2";
//    string result="result";
//    jstring jResult=env->NewStringUTF(result.data());
//    return jResult;

    char version[50];
    //  2.3
    sprintf(version, "librtmp version: %d", RTMP_LibVersion());
    // ___________________________________> 下面是x264 验证  视频编码
    x264_picture_t *picture = new x264_picture_t;


    return env->NewStringUTF(version);
}