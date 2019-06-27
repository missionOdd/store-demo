package com.mission.store.entity.base;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Listener - 创建日期、修改日期
 * @author mission
 * @date 2019/6/7 9:47
 */
public class EntityListener {

  /**
   * 保存前处理
   *
   * @param entity
   *            实体对象
   */
  @PrePersist
  public void prePersist(BaseEntity<?> entity) {
    entity.setCreatedTime(new Date());
  }

  /**
   * 更新前处理
   *
   * @param entity
   *            实体对象
   */
  @PreUpdate
  public void preUpdate(BaseEntity<?> entity) {
    entity.setModifiedTime(new Date()); }
}
