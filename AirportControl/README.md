# AirportControl: Stakeholder Requirements

Abstract: This document contains the requirments for a airport control system.

1. Runways
    + Each runway must have a unique identifier.
2. Actions
    + Users should be able to secure one of the free runways for arriving aircraft if weather codtions are met.
    + Users should be able to see when an aircraft has arrived safely and landed.
    + Add new runways.
    + Remove runways. 
    + The system must provide an API for surveying and evaluating meteorological data.
    + The system must handle special weather conditions.
3. Performance
    + The system should support concurrent access by multiple threads.
    + The system must ensure data integrity.