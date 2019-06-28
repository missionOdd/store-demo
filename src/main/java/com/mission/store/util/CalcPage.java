package com.mission.store.util;

/**
 * @author mission
 * @date 2019/06/28 11:05
 */
public class CalcPage {

  public static Integer getIndex(Integer page,Integer size){
    return (page>0)?(page-1)*size:0;
  }

}
