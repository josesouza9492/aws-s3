package com.dchristofolli.projects.awss3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseModel {
    private String bucket;
    private FolderModel folder;
    private List<FileModel> files;
    private Integer quantity;
    private String totalFileSize;
}
