DELIMITER //
DROP PROCEDURE IF EXISTS `sp_pc_upsert`//

CREATE PROCEDURE sp_pc_upsert
	(
		IN p_pc_id INTEGER,
		IN p_pc VARCHAR(7),
		IN p_ldu_type_cde VARCHAR(50),
		IN p_fsa_id INTEGER,
		IN p_fsa VARCHAR(3),
		IN p_lfcl_stat_cde VARCHAR(50),
		IN p_dm_type_cd VARCHAR(50),
		IN p_dm_disp_nme VARCHAR(6),
		IN p_df_id INTEGER,
		IN p_df_disp_nme VARCHAR(100),
		IN p_df_pc_id INTEGER,
		IN p_df_pc_disp_nme VARCHAR(7),
		IN p_rpo_id INTEGER,
		IN p_rpo_nme VARCHAR(50),
		IN p_rpo_bus_nme VARCHAR(50),
		IN p_rpo_addr_line1 VARCHAR(50),
		IN p_rpo_addr_line3 VARCHAR(50),
		IN p_latitude DECIMAL(38,8),
		IN p_longitude DECIMAL(38,8)
	)
BEGIN

	REPLACE INTO AMS_PC_SPD
		(
			PC_ID,
			PC,
			LDU_TYPE_CDE,
			FSA_ID,
			FSA,
			LFCL_STAT_CDE,
			DM_TYPE_CDE,
			DM_DISP_NME,
			DF_ID,
			DF_DISP_NME,
			DF_PC_ID,
			DF_PC_DISP_NME,
			RPO_ID,
			RPO_NME,
			RPO_BUS_NME,
			RPO_ADDR_LINE1,
			RPO_ADDR_LINE3,
			LATITUDE,
			LONGITUDE
		)
	VALUES
		(
			p_pc_id,
			p_pc,
			p_ldu_type_cde,
			p_fsa_id,
			p_fsa,
			p_lfcl_stat_cde,
			p_dm_type_cd,
			p_dm_disp_nme,
			p_df_id,
			p_df_disp_nme,
			p_df_pc_id,
			p_df_pc_disp_nme,
			p_rpo_id,
			p_rpo_nme,
			p_rpo_bus_nme,
			p_rpo_addr_line1,
			p_rpo_addr_line3,
			p_latitude,
			p_longitude
		);
END//

DELIMITER ;
