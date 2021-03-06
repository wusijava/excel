package com.wusi.reimbursement.service;

import java.util.Map;

/**
 * @author lvlu
 * @date 2019/12/31 17:12
 */
public interface UploadService {

    Map<String, Object> getUploadToken(String fileName);

    boolean moveFile(String oldFileName, String newFileName);
}
