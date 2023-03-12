#include <rtmp.h>
#include "VideoChannel.h"
#include "util.h"

VideoChannel::VideoChannel() {
    pthread_mutex_init(&mutex, 0);
}

VideoChannel::~VideoChannel() {
    pthread_mutex_destroy(&mutex);
}

// 初始化 x264 编码器
void VideoChannel::initVideoEncoder(int width, int height, int fps, int bitrate) {

}

/**
 * 编码工作
 * @param data
 */
void VideoChannel::encodeData(signed char *data) {

}

// 把sps + pps 存入队列
void VideoChannel::sendSpsPps(uint8_t *sps, uint8_t *pps, int sps_len, int pps_len) {

}

void VideoChannel::setVideoCallback( VideoCallback videoCallback) {
    this->videoCallback = videoCallback;
}

/* 发送帧信息
* @param type 帧类型
* @param payload 帧数据长度
* @param pPayload 帧数据
*/
void VideoChannel::sendFrame(int type, int payload, uint8_t *pPayload) {

}


