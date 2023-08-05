package com.kcorteser.challenge.models.mappers;

import com.kcorteser.challenge.models.DTO.TaskDTO;
import com.kcorteser.challenge.models.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO taskEntityToDto(TaskEntity taskEntity);


    List<TaskDTO> taskEntitiesToDtos(List<TaskEntity> taskEntities);
}
