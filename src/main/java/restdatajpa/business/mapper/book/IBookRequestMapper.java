package restdatajpa.business.mapper.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import restdatajpa.domain.dto.request.BookRequest;
import restdatajpa.domain.entity.BookEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IBookRequestMapper {
    @Mapping(target = "id",
             ignore = true)
    BookEntity toBookEntity(BookRequest bookRequest);
}
