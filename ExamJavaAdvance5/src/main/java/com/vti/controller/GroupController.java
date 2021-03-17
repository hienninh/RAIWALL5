package com.vti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vti.DTO.createGroupDTO;
import com.vti.DTO.viewGroupDTO;
import com.vti.entity.Group;
import com.vti.filter.FilterGroupDto;
import com.vti.service.IGroupService;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin(origins = "http://127.0.0.1:5500")
//@CrossOrigin(origins = "*")
@Validated
public class GroupController {
	@Autowired
	private IGroupService groupSerice;

	@GetMapping()
//	Paging, sorting
//	
//	public ResponseEntity<?> getAllGroup(@RequestParam(defaultValue = "1") int pageNumber,
//			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "DESC") String sortType,
//			@RequestParam(defaultValue = "id") String sortField) {
//		// convert Page<Group> --> Page<ViewGroupDto>
//		Page<Group> groups = groupSerice.getAllGroup(pageNumber, pageSize, sortField, sortType);
//		Page<viewGroupDTO> dtoPage = groups.map(new Function<Group, viewGroupDTO>() {
//			@Override
//			public viewGroupDTO apply(Group entity) {
//				return entity.toEntity();
//			}
//		});
//
//		return new ResponseEntity<Page<viewGroupDTO>>(dtoPage, HttpStatus.OK);
//	}

//	Filter
	public ResponseEntity<?> getAllGroup(FilterGroupDto filte, @RequestParam(required = false) String search) {
		// convert Page<Group> --> Page<ViewGroupDto>
		List<Group> groups = groupSerice.getAllGroup(filte, search);
		List<viewGroupDTO> dtos = new ArrayList<>();
//		 convert entity to dto
		for (Group entity : groups) {
			viewGroupDTO dto;
			dto = new viewGroupDTO(entity.getId(), entity.getGroupName(), entity.getAmountMember(),
					entity.getCreatetime(), entity.getCreator().getFullname());
			dtos.add(dto);
		}
		return new ResponseEntity<List<viewGroupDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<viewGroupDTO> getGroupByID(@PathVariable(name = "id") Short id) {
		Group group = groupSerice.getGroupByID(id);
		if (groupSerice.isGroupExistsByID(id) == false) {
			throw new EntityNotFoundException("Không thể xem, vì ID vừa nhập vào không có^^");
		}
		Short id1 = id;
		if (id1 instanceof Short) {
			viewGroupDTO dto;
			dto = new viewGroupDTO(group.getId(), group.getGroupName(), group.getAmountMember(), group.getCreatetime(),
					group.getCreator().getFullname());
			return new ResponseEntity<viewGroupDTO>(dto, HttpStatus.OK);
		}
		throw new TypeMismatchException("Bạn phải nhập dữ liệu dạng số. Mời bạn nhập lại!");
	}

	@PostMapping()
	public ResponseEntity<?> createGroup(@Valid @RequestBody createGroupDTO dto) {
		groupSerice.createGroup(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateGroupById(@PathVariable(name = "id") short id,
			@Valid @RequestBody createGroupDTO dto) {
		Group group = dto.toEntity();
		group.setId(id);
		groupSerice.updateGroupById(group);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGroupByID(@PathVariable(name = "id") short id) {
		if (groupSerice.isGroupExistsByID(id) == false) {
			throw new EntityNotFoundException("Không thể xóa, vì ID vừa nhập vào không có ^^");
		}
		groupSerice.deleteGroupByID(id);

		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

//	@DeleteMapping()
//	public ResponseEntity<?> deleteGroupsWithIds(@RequestParam List<Short> ids) {
//		groupSerice.deleteGroupsWithIds(ids);
//		return new ResponseEntity<String>("Delete many groups successfully!", HttpStatus.OK);
//	}

	// delete array id
	@DeleteMapping()
	public ResponseEntity<?> deleteGroupByIds(@RequestParam List<Short> ids) {
		groupSerice.deleteGroupByIds(ids);
		return new ResponseEntity<String>("Delete many groups successfully!", HttpStatus.OK);
	}

}
