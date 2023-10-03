package restdatajpa.business.mapper.book;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import restdatajpa.domain.dto.BookDto;
import restdatajpa.domain.entity.BookEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IBookDtoMapper {
    BookDto toBookDto(BookEntity bookEntity);
    List<BookDto> toBookDtoList(List<BookEntity> bookEntityList);
}
