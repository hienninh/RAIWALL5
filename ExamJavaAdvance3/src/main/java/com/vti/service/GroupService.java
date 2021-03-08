package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.Specification.SpectificationBuilder;
import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.filter.FilterGroupDto;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IGroupRepository;

@Service
public class GroupService implements IGroupService {
	@Autowired
	private IGroupRepository repository;

	@Autowired
	private IAccountRepository accountRepository;

	@Override
//	public Page<Group> getAllGroup(int pageNumber, int pageSize, String sortField, String sortType,
//			FilterGroupDto filte, String search) {
//		Sort sort = sortType.equals("DESC") ? Sort.by(sortField).descending() : Sort.by(sortField).ascending();
//		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
//		Page<Group> page = repository.findAll(pageable);
//
//		return page;
//	}

//	Filter
	public List<Group> getAllGroup(FilterGroupDto filter, String searchstr) {
		SpectificationBuilder<Group> spectificationGroup = new SpectificationBuilder<Group>();
//		true is or, false is and
//		if (!StringUtils.isEmpty(searchstr)) {
//			
//		}
		if (searchstr != null) {
			spectificationGroup.with(true, "groupName", "Like", searchstr);
		}
		if (filter.getMinId() > 0) {
			spectificationGroup.with(false, "id", ">", filter.getMinId());
		}
		if (filter.getMaxId() > 0) {
			spectificationGroup.with(true, "id", "<", filter.getMaxId());
		}
//		buider là xây ra 1 spectification hay where
		return repository.findAll(spectificationGroup.Builder());
	}

	@Override
	public Group getGroupByID(short Id) {
		return repository.findById(Id).get();
	}

	@Override
	public void updateGroupById(Group group) {
		short defaultAccountID = 1;
		Account account = accountRepository.findById(defaultAccountID).get();

		group.setCreator(account);
		repository.save(group);
	}

	@Override
	public void deleteGroupByID(short Id) {
		repository.deleteById(Id);
	}

	@Override
	public Group createGroup(Group group) {

		// set default creator
		short defaultAccountID = 1;
		Account account = accountRepository.findById(defaultAccountID).get();
		group.setCreator(account);
		return repository.save(group);
	}

	@Override
	public boolean isGroupExistsByID(short id) {
		return repository.existsById(id);
	}

	@Override
	public boolean existByGroupName(String groupName) {
		return repository.existsByGroupName(groupName);
	}

//	@Override
//	public void deleteGroupsWithIds(List<Short> ids) {
//		repository.deleteGroupsWithIds(ids);
//	}
	@Override
	public void deleteGroupByIds(List<Short> ids) {
		repository.deleteGroupsWithIds(ids);
	}

}
