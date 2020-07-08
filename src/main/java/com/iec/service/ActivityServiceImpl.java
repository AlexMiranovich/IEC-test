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
import com.iec.entity.Activity;
import com.iec.entity.ChangeTypes;
import com.iec.entity.Changes;
import com.iec.entity.History;
import com.iec.exception.ActivityException;
import com.iec.exception.HistoryException;
import com.iec.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService{

	private final ActivityRepository activityRepository;
	
	private final HistoryServiceImpl historyServiceImpl;

	public ActivityServiceImpl(ActivityRepository activityRepository, HistoryServiceImpl historyServiceImpl) {
		this.activityRepository = activityRepository;
		this.historyServiceImpl = historyServiceImpl;
	}

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

	private Date getCurrentDate() {
   	 	 Calendar calobj = Calendar.getInstance();
	   	 try {
			 return dateFormat.parse(dateFormat.format(calobj.getTime()));
			} catch (ParseException exception) {
				exception.printStackTrace();
			}
	   	 return null;
    }
	
	@Override
	public List<Activity> getActivities(){
		return activityRepository.findAll();
	}
	
	@Override
	public void saveActivity(Activity activity) throws ActivityException, HistoryException{
		Optional<Activity> activityDB = activityRepository.findActivityByTitle(activity.getTitle());
		if(activityDB.isPresent()) {
			 throw new ActivityException(MessageConstants.ACTIVITY_ALREDY_EXISTS);
		}
		activityRepository.insert(activity);
		historyServiceImpl.saveHistory(new History(activity.getId(), getCurrentDate(),ChangeTypes.COMPOSE,null));
	}
	
	@Override
	public void deleteActivity(Activity activity){
		activityRepository.delete(activity);
		historyServiceImpl.deleteHistoryByActivityId(activity.getId());
	}

	@Override
	public void updateActivity(Activity activity) throws ActivityException, HistoryException{
		Optional<Activity> activityDB = activityRepository.findActivityById(activity.getId());
		if(activityDB.isPresent()) {
			Activity updatedActivity = activityDB.get();
			List<Changes> listOfChanges = new ArrayList<>();
			if(!updatedActivity.getTitle().equals(activity.getTitle())) {
				listOfChanges.add(new Changes(activity.getId(), "title", updatedActivity.getTitle(), activity.getTitle()));
			}
			if(!updatedActivity.getSummary().equals(activity.getSummary())) {
				listOfChanges.add(new Changes(activity.getId(), "summary", updatedActivity.getSummary(), activity.getSummary()));
			}
			if(!updatedActivity.getDescription().equals(activity.getDescription())) {
				listOfChanges.add(new Changes(activity.getId(), "description", updatedActivity.getDescription(), activity.getDescription()));
			}
			if(!updatedActivity.getStartDateTime().equals(activity.getStartDateTime())) {
				listOfChanges.add(new Changes(activity.getId(), "startDateTime", updatedActivity.getStartDateTime().toString(), activity.getStartDateTime().toString()));
			}
			if(!updatedActivity.getEndDateTime().equals(activity.getEndDateTime())) {
				listOfChanges.add(new Changes(activity.getId(), "endDateTime", updatedActivity.getEndDateTime().toString(), activity.getEndDateTime().toString()));
			}
			if(!updatedActivity.getInfo().equals(activity.getInfo())) {
				listOfChanges.add(new Changes(activity.getId(), "info", updatedActivity.getInfo(), activity.getInfo()));
			}
			activityRepository.delete(updatedActivity);
			activityRepository.insert(activity);
			historyServiceImpl.saveHistory(new History(activity.getId(), getCurrentDate(),ChangeTypes.UPDATE,listOfChanges));
		} else {
			throw new ActivityException(MessageConstants.ACTIVITY_DO_NOT_EXISTS);
		}
	}

}