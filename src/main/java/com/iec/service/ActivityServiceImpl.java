package com.iec.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.constants.MessageConstants;
import com.iec.entity.ActivityEntity;
import com.iec.entity.ChangeTypes;
import com.iec.entity.ChangesEntity;
import com.iec.entity.HistoryEntity;
import com.iec.exception.ActivityException;
import com.iec.exception.HistoryException;
import com.iec.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private HistoryServiceImpl historyServiceImpl;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	
	private Date getCurrentDate() {
   	 	 Calendar calobj = Calendar.getInstance();
	   	 try {
				Date currentDate = dateFormat.parse(dateFormat.format(calobj.getTime()));
				return  currentDate;
			} catch (ParseException exception) {
				exception.printStackTrace();
			}
	   	 return null;
    }
	
	@Override
	public List<ActivityEntity> getActivities(){
		return activityRepository.findAll();
	}
	
	@Override
	public String saveActivity(ActivityEntity activityEntity) throws ActivityException, HistoryException{
		Optional<ActivityEntity> activityDB = activityRepository.findActivityByTitle(activityEntity.getTitle());
		if(!activityDB.isEmpty()) {
			 throw new ActivityException(MessageConstants.ACTIVITY_ALREDY_EXISTS);
		};
		activityRepository.insert(activityEntity);
		historyServiceImpl.saveHistory(new HistoryEntity(activityEntity.getId(), getCurrentDate(),ChangeTypes.COMPOSE,null));
		return  MessageConstants.ACTIVITY_ADDED_SUCCESSFULLY;
	}
	
	@Override
	public String deleteActivity(ActivityEntity activityEntity){
		activityRepository.delete(activityEntity);
		historyServiceImpl.deleteHistoryByActivityId(activityEntity.getId());
		return  MessageConstants.ACTIVITY_DELETED_SUCCESSFULLY;
	}

	@Override
	public String updateActivity(ActivityEntity activityEntity) throws ActivityException, HistoryException{
		Optional<ActivityEntity> activityDB = activityRepository.findActivityById(activityEntity.getId());
		if(activityDB.isPresent()) {
			ActivityEntity updatedActivity = activityDB.get();
			List<ChangesEntity> listOfChanges = new ArrayList<>();
			if(updatedActivity.getTitle() != activityEntity.getTitle()) {
				listOfChanges.add(new ChangesEntity(activityEntity.getId(), "title", updatedActivity.getTitle(), activityEntity.getTitle()));
			}
			if(updatedActivity.getSummary() != activityEntity.getSummary()) {
				listOfChanges.add(new ChangesEntity(activityEntity.getId(), "summary", updatedActivity.getSummary(), activityEntity.getSummary()));
			}
			if(updatedActivity.getDescription() != activityEntity.getDescription()) {
				listOfChanges.add(new ChangesEntity(activityEntity.getId(), "description", updatedActivity.getDescription(), activityEntity.getDescription()));
			}
			if(updatedActivity.getStartDateTime() != activityEntity.getStartDateTime()) {
				listOfChanges.add(new ChangesEntity(activityEntity.getId(), "startDateTime", updatedActivity.getStartDateTime().toString(), activityEntity.getStartDateTime().toString()));
			}
			if(updatedActivity.getEndDateTime() != activityEntity.getEndDateTime()) {
				listOfChanges.add(new ChangesEntity(activityEntity.getId(), "endDateTime", updatedActivity.getEndDateTime().toString(), activityEntity.getEndDateTime().toString()));
			}
			if(updatedActivity.getInfo() != activityEntity.getInfo()) {
				listOfChanges.add(new ChangesEntity(activityEntity.getId(), "info", updatedActivity.getInfo(), activityEntity.getInfo()));
			}
			activityRepository.delete(updatedActivity);
			activityRepository.insert(activityEntity);
			historyServiceImpl.saveHistory(new HistoryEntity(activityEntity.getId(), getCurrentDate(),ChangeTypes.UPDATE,listOfChanges));
		} else {
			throw new ActivityException(MessageConstants.ACTIVITY_DO_NOT_EXISTS);
		}
		return MessageConstants.ACTIVITY_UPDATED_SUCCESSFULLY;
	}

}