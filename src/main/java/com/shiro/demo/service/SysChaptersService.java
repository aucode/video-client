package com.shiro.demo.service;




import com.shiro.demo.pojo.SysChapters;

import java.util.List;

/**
 * <p>
 * (章节表) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysChaptersService {

    int saveChatersInfoByCourseId(SysChapters chapters);

    List<SysChapters> selectChaptersList(SysChapters chapters);

    List<SysChapters> queryChaptersByCourseId(SysChapters chapters);

    SysChapters queryChaptersByChaptersId(SysChapters chapters);

}
