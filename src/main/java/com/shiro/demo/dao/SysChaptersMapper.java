package com.shiro.demo.dao;



import com.shiro.demo.pojo.SysChapters;

import java.util.List;

/**
 * <p>
 * (章节表) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysChaptersMapper {
    int saveChatersInfoByCourseId(SysChapters chapters);

    List<SysChapters> selectChaptersList(SysChapters chapters);

    List<SysChapters> queryChaptersByCourseId(SysChapters chapters);

    SysChapters queryChaptersByChaptersId(SysChapters chapters);
}
