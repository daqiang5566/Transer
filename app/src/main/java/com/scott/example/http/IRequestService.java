package com.scott.example.http;

import com.scott.example.moudle.FileInfo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * <P>Author: shijiale</P>
 * <P>Date: 2018/2/3</P>
 * <P>Email: shilec@126.com</p>
 */

public interface IRequestService {

    @GET("FileListGet")
    Observable<List<FileInfo>> getFileList(@Query("path") String path, @Query("pageSize") int pageSize);
}
